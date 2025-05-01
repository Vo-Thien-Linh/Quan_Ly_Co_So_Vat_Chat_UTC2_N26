package Repository;

import Config.DatabaseConnection;
import Model.BorrowingRequestStatus;
import Model.DeviceBorrowRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceBorrowRequestRepository {

    public List<DeviceBorrowRequest> getPendingRequests() throws SQLException {
        List<DeviceBorrowRequest> requests = new ArrayList<>();
        String sql = """
            SELECT dbr.id_request, dbr.lecturer_user, u.fullname, dbr.device_id, 
                   dbr.request_date, dbr.due_date, dbr.borrowing_request
            FROM device_borrow_requests dbr
            JOIN users u ON dbr.lecturer_user = u.user_id
            WHERE dbr.borrowing_request = 'PENDING'
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DeviceBorrowRequest request = new DeviceBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
                request.setFullname(rs.getString("fullname"));
                request.setDeviceId(rs.getString("device_id"));
                request.setRequestDate(rs.getTimestamp("request_date"));
                request.setDueDate(rs.getTimestamp("due_date"));
                request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                requests.add(request);
            }
        }
        return requests;
    }

    public List<DeviceBorrowRequest> getAllRequests() throws SQLException {
        List<DeviceBorrowRequest> requests = new ArrayList<>();
        String sql = """
            SELECT dbr.id_request, dbr.lecturer_user, u.fullname, dbr.device_id, 
                   dbr.request_date, dbr.due_date, dbr.borrowing_request
            FROM device_borrow_requests dbr
            JOIN users u ON dbr.lecturer_user = u.user_id
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DeviceBorrowRequest request = new DeviceBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
                request.setFullname(rs.getString("fullname"));
                request.setDeviceId(rs.getString("device_id"));
                request.setRequestDate(rs.getTimestamp("request_date"));
                request.setDueDate(rs.getTimestamp("due_date"));
                request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                requests.add(request);
            }
        }
        return requests;
    }

    public boolean updateRequestStatus(String idRequest, BorrowingRequestStatus status) throws SQLException {
        String sql = "UPDATE device_borrow_requests SET borrowing_request = ? WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setString(2, idRequest);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}