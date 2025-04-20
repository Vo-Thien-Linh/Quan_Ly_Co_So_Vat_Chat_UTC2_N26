package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import Model.BorrowingRequestStatus;
import Model.Room;
import Model.RoomBorrowRequest;
import Model.RoomStatus;
import Repository.RoomRepository;
import Repository.RoomBorrowRequestRepository;
import View.Panel_ManagerRoom;
import Config.DatabaseConnection;

public class RoomController {
    private Panel_ManagerRoom view;
    private RoomRepository roomRepository;
    private RoomBorrowRequestRepository requestRepository;

    public RoomController(Panel_ManagerRoom view) throws SQLException {
        this.view = view;
        this.roomRepository = new RoomRepository();
        this.requestRepository = new RoomBorrowRequestRepository();
    }

    public boolean approveBorrowRequest(String idRequest, BorrowingRequestStatus status) throws SQLException {
        // Kiểm tra xem đơn có tồn tại không
        if (!requestRepository.existsRequest(idRequest)) {
            return false;
        }

        // Lấy thông tin đơn mượn để kiểm tra thời gian
        RoomBorrowRequest request = requestRepository.getRequestById(idRequest);
        if (request == null) {
            throw new SQLException("Không tìm thấy đơn mượn: " + idRequest);
        }

        // Lấy roomId từ đơn mượn
        String roomId = requestRepository.getRoomIdByRequest(idRequest);
        if (roomId == null) {
            throw new SQLException("Không tìm thấy phòng liên quan đến đơn mượn: " + idRequest);
        }

        // Kiểm tra trạng thái phòng
        String sqlStatus = "SELECT status FROM room WHERE room_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlStatus)) {
            stmt.setString(1, roomId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String currentStatus = rs.getString("status");
                if (!currentStatus.equals("AVAILABLE")) {
                    throw new SQLException("Phòng hiện không sẵn sàng để mượn: trạng thái " + currentStatus);
                }
            } else {
                throw new SQLException("Không tìm thấy phòng: " + roomId);
            }
        }

        // Kiểm tra xung đột thời gian với các đơn đã duyệt
        String sqlTimeConflict = "SELECT COUNT(*) FROM borrowing_room_request " +
                                 "WHERE room_id = ? AND borrowing_request = 'APPROVED' " +
                                 "AND ((request_date <= ? AND due_date >= ?) OR " +
                                 "(request_date <= ? AND due_date >= ?) OR " +
                                 "(request_date >= ? AND due_date <= ?))";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlTimeConflict)) {
            stmt.setString(1, roomId);
            stmt.setTimestamp(2, new Timestamp(request.getRequestDate().getTime()));
            stmt.setTimestamp(3, new Timestamp(request.getRequestDate().getTime()));
            stmt.setTimestamp(4, new Timestamp(request.getDueDate().getTime()));
            stmt.setTimestamp(5, new Timestamp(request.getDueDate().getTime()));
            stmt.setTimestamp(6, new Timestamp(request.getRequestDate().getTime()));
            stmt.setTimestamp(7, new Timestamp(request.getDueDate().getTime()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                throw new SQLException("Phòng đã được mượn trong khoảng thời gian này!");
            }
        }

        // Cập nhật trạng thái đơn mượn
        boolean success = requestRepository.updateRequestStatus(idRequest, status);

        // Nếu cập nhật thành công và trạng thái là APPROVED, cập nhật trạng thái phòng
        if (success && status == BorrowingRequestStatus.APPROVED) {
            roomRepository.updateRoomStatus(roomId, RoomStatus.OCCUPIED);
        }

        return success;
    }

    public void addRoom(Room room) throws SQLException {
        roomRepository.addRoom(room);
    }

    public void updateRoom(Room room) throws SQLException {
        roomRepository.updateRoom(room);
    }

    public void deleteRoom(String roomId) throws SQLException {
        roomRepository.deleteRoom(roomId);
    }

    public List<Room> getAllRooms() throws SQLException {
        return roomRepository.getAllRooms();
    }
}