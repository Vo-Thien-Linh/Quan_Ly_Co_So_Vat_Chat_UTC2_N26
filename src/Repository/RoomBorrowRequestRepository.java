package Repository;

import Config.DatabaseConnection;
import Model.RoomBorrowRequest;
import Model.BorrowingRequestStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomBorrowRequestRepository {

    public List<RoomBorrowRequest> getPendingRequests() throws SQLException {
        List<RoomBorrowRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM borrowing_room_request WHERE borrowing_request = 'PENDING'";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RoomBorrowRequest request = new RoomBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
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
        String sql = "SELECT * FROM borrowing_room_request";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RoomBorrowRequest request = new RoomBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
                request.setRoomId(rs.getString("room_id"));
                request.setRequestDate(rs.getTimestamp("request_date"));
                request.setDueDate(rs.getTimestamp("due_date"));
                request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                requests.add(request);
            }
        }
        return requests;
    }

    public RoomBorrowRequest getRequestById(String idRequest) throws SQLException {
        String sql = "SELECT * FROM borrowing_room_request WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idRequest);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    RoomBorrowRequest request = new RoomBorrowRequest();
                    request.setIdRequest(rs.getString("id_request"));
                    request.setLecturerUser(rs.getString("lecturer_user"));
                    request.setRoomId(rs.getString("room_id"));
                    request.setRequestDate(rs.getTimestamp("request_date"));
                    request.setDueDate(rs.getTimestamp("due_date"));
                    request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                    return request;
                }
            }
        }
        return null;
    }

    public boolean existsRequest(String idRequest) throws SQLException {
        String sql = "SELECT COUNT(*) FROM borrowing_room_request WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idRequest);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean updateRequestStatus(String idRequest, BorrowingRequestStatus status) throws SQLException {
        String sql = "UPDATE borrowing_room_request SET borrowing_request = ? WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setString(2, idRequest);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public String getRoomIdByRequest(String idRequest) throws SQLException {
        String sql = "SELECT room_id FROM borrowing_room_request WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idRequest);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("room_id");
            }
        }
        return null;
    }
}