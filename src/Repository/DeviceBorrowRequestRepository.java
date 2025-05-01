package Repository;

import Config.DatabaseConnection;
import Model.DeviceBorrowRequest;
import Model.BorrowingRequestStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceBorrowRequestRepository {
    public void addRequest(DeviceBorrowRequest request) throws SQLException {
        String sql = """
            INSERT INTO device_borrow_requests (lecturer_user, device_id, request_date, due_date, borrowing_request)
            VALUES (?, ?, ?, ?, ?)
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, request.getLecturerUser());
            stmt.setString(2, request.getDeviceId());
            stmt.setTimestamp(3, new java.sql.Timestamp(request.getRequestDate().getTime()));
            stmt.setTimestamp(4, new java.sql.Timestamp(request.getDueDate().getTime()));
            stmt.setString(5, request.getBorrowingRequest().name());
            stmt.executeUpdate();
        }
    }

    public List<DeviceBorrowRequest> getPendingRequests() throws SQLException {
        List<DeviceBorrowRequest> requests = new ArrayList<>();
        String sql = """
            SELECT br.id_request, br.lecturer_user, br.device_id, br.request_date, br.due_date, br.borrowing_request
            FROM device_borrow_requests br
            WHERE br.borrowing_request = 'PENDING'
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DeviceBorrowRequest request = new DeviceBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
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
            SELECT br.id_request, br.lecturer_user, br.device_id, br.request_date, br.due_date, br.borrowing_request
            FROM device_borrow_requests br
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DeviceBorrowRequest request = new DeviceBorrowRequest();
                request.setIdRequest(rs.getString("id_request"));
                request.setLecturerUser(rs.getString("lecturer_user"));
                request.setDeviceId(rs.getString("device_id"));
                request.setRequestDate(rs.getTimestamp("request_date"));
                request.setDueDate(rs.getTimestamp("due_date"));
                request.setBorrowingRequest(BorrowingRequestStatus.valueOf(rs.getString("borrowing_request")));
                requests.add(request);
            }
        }
        return requests;
    }

    public String getDeviceIdByRequest(String idRequest) throws SQLException {
        String sql = "SELECT device_id FROM device_borrow_requests WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idRequest);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("device_id");
                }
            }
        }
        return null;
    }

    public boolean updateRequestStatus(String idRequest, BorrowingRequestStatus status) throws SQLException {
        String sql = "UPDATE device_borrow_requests SET borrowing_request = ? WHERE id_request = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setString(2, idRequest);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}