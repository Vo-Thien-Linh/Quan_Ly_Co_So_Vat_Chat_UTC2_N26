package Repository;

import Config.DatabaseConnection;
import Model.RoomBorrowRequest;
import Model.BorrowingRequestStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBorrowRequestRepository {
	//
	public void addRequest(RoomBorrowRequest request) throws SQLException {
        String sql = """
            INSERT INTO borrowing_room_request (id_request, lecturer_user, room_id, request_date, due_date, borrowing_request)
            VALUES (?, ?, ?, ?, ?, ?)
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, request.getIdRequest());
            stmt.setString(2, request.getLecturerUser());
            stmt.setString(3, request.getRoomId());
            stmt.setTimestamp(4, new java.sql.Timestamp(request.getRequestDate().getTime()));
            stmt.setTimestamp(5, new java.sql.Timestamp(request.getDueDate().getTime()));
            stmt.setString(6, request.getBorrowingRequest().name());
            stmt.executeUpdate();
        }
    }
    public List<RoomBorrowRequest> getPendingRequests() throws SQLException {
        List<RoomBorrowRequest> requests = new ArrayList<>();
        String sql = """
            SELECT br.id_request, br.lecturer_user, u.fullname, br.room_id, 
                   br.request_date, br.due_date, br.borrowing_request
            FROM borrowing_room_request br
            JOIN users u ON br.lecturer_user = u.user_id
            WHERE br.borrowing_request = 'PENDING'
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RoomBorrowRequest request = new RoomBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
                request.setFullname(rs.getString("fullname"));
                request.setRoomId(rs.getString("room_id"));
                request.setRequestDate(rs.getTimestamp("request_date"));
                request.setDueDate(rs.getTimestamp("due_date"));
                request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                requests.add(request);
            }
        }
        return requests;
    }

    public List<RoomBorrowRequest> getAllRequests() throws SQLException {
        List<RoomBorrowRequest> requests = new ArrayList<>();
        String sql = """
            SELECT br.id_request, br.lecturer_user, u.fullname, br.room_id, 
                   br.request_date, br.due_date, br.borrowing_request
            FROM borrowing_room_request br
            JOIN users u ON br.lecturer_user = u.user_id
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RoomBorrowRequest request = new RoomBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
                request.setFullname(rs.getString("fullname"));
                request.setRoomId(rs.getString("room_id"));
                request.setRequestDate(rs.getTimestamp("request_date"));
                request.setDueDate(rs.getTimestamp("due_date"));
                request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                requests.add(request);
            }
        }
        return requests;
    }

    public String getRoomIdByRequest(String idRequest) throws SQLException {
        String sql = "SELECT room_id FROM borrowing_room_request WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idRequest);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("room_id");
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public boolean updateRequestStatus(String idRequest, BorrowingRequestStatus status) throws SQLException {
        String sql = "UPDATE borrowing_room_request SET borrowing_request = ? WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setString(2, idRequest);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
 // Thêm yêu cầu mượn phòng với kiểm tra dữ liệu hợp lệ trước
    public void addRequestWithValidation(RoomBorrowRequest request) throws SQLException {
        // Kiểm tra các giá trị đầu vào để tránh lỗi null
        if (request.getLecturerUser() == null || request.getRoomId() == null ||
            request.getRequestDate() == null || request.getDueDate() == null ||
            request.getBorrowingRequest() == null) {
            throw new IllegalArgumentException("Thông tin yêu cầu mượn phòng không đầy đủ.");
        }

        // Không gán id_request để trigger tự động tạo
        request.setIdRequest(null);

        // Gọi phương thức addRequest hiện có
        addRequest(request);
    }
}