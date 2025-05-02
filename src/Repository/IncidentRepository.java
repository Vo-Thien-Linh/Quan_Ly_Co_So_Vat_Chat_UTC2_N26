package Repository;

import Config.DatabaseConnection;
import Model.Incident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncidentRepository {
    public void createIncident(Incident incident) throws SQLException {
        String sql = """
            INSERT INTO incident (reported_by, device_id, room_id, description, report_date, status)
            VALUES (?, ?, ?, ?, ?, ?)
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, incident.getReportedBy());
            stmt.setString(2, incident.getDeviceId());
            stmt.setString(3, incident.getRoomId());
            stmt.setString(4, incident.getDescription());
            stmt.setTimestamp(5, new java.sql.Timestamp(incident.getReportDate().getTime()));
            stmt.setString(6, incident.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Incident> findByDeviceId(String deviceId) throws SQLException {
        List<Incident> incidents = new ArrayList<>();
        String sql = """
            SELECT * FROM incident WHERE device_id = ?
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviceId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Timestamp reportDateTimestamp = rs.getTimestamp("report_date");
                    Date reportDate = reportDateTimestamp != null ? new Date(reportDateTimestamp.getTime()) : null;
                    incidents.add(new Incident(
                        rs.getString("id_report"),
                        rs.getString("reported_by"),
                        rs.getString("device_id"),
                        rs.getString("room_id"),
                        rs.getString("description"),
                        reportDate,
                        rs.getString("handled_by"),
                        rs.getString("status")
                    ));
                }
            }
        }
        return incidents;
    }

    public List<Incident> findByRoomId(String roomId) throws SQLException {
        List<Incident> incidents = new ArrayList<>();
        String sql = """
            SELECT * FROM incident WHERE room_id = ?
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, roomId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Timestamp reportDateTimestamp = rs.getTimestamp("report_date");
                    Date reportDate = reportDateTimestamp != null ? new Date(reportDateTimestamp.getTime()) : null;
                    incidents.add(new Incident(
                        rs.getString("id_report"),
                        rs.getString("reported_by"),
                        rs.getString("device_id"),
                        rs.getString("room_id"),
                        rs.getString("description"),
                        reportDate,
                        rs.getString("handled_by"),
                        rs.getString("status")
                    ));
                }
            }
        }
        return incidents;
    }

    public List<Incident> getAllIncidents() throws SQLException {
        List<Incident> incidents = new ArrayList<>();
        String sql = """
            SELECT * FROM incident
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Timestamp reportDateTimestamp = rs.getTimestamp("report_date");
                Date reportDate = reportDateTimestamp != null ? new Date(reportDateTimestamp.getTime()) : null;
                incidents.add(new Incident(
                    rs.getString("id_report"),
                    rs.getString("reported_by"),
                    rs.getString("device_id"),
                    rs.getString("room_id"),
                    rs.getString("description"),
                    reportDate,
                    rs.getString("handled_by"),
                    rs.getString("status")
                ));
            }
        }
        return incidents;
    }

    public void updateIncidentHandling(String idReport, String newDescription, String handledBy, String status) throws SQLException {
        String sql = """
            UPDATE incident 
            SET description = ?, handled_by = ?, status = ?
            WHERE id_report = ?
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newDescription);
            stmt.setString(2, handledBy);
            stmt.setString(3, status);
            stmt.setString(4, idReport);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Không tìm thấy sự cố với ID: " + idReport);
            }
        }
    }

    public Incident findByIdReport(String idReport) throws SQLException {
        String sql = """
            SELECT * FROM incident WHERE id_report = ?
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idReport);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Timestamp reportDateTimestamp = rs.getTimestamp("report_date");
                    Date reportDate = reportDateTimestamp != null ? new Date(reportDateTimestamp.getTime()) : null;
                    return new Incident(
                        rs.getString("id_report"),
                        rs.getString("reported_by"),
                        rs.getString("device_id"),
                        rs.getString("room_id"),
                        rs.getString("description"),
                        reportDate,
                        rs.getString("handled_by"),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }
}