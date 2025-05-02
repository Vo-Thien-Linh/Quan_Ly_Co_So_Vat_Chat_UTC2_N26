package Repository;

import Config.DatabaseConnection;
import Model.Device;
import Model.DeviceStatus;
import Model.Room;
import Model.RoomStatus;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeviceRepository {
    public void addDevice(Device device) throws SQLException {
        String sql = "INSERT INTO devices (device_name, device_type, purchase_date, supplier, price, status, room_id, quantity, deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, device.getDeviceName());
            stmt.setString(2, device.getDeviceType());
            stmt.setDate(3, device.getPurchaseDate() != null ? java.sql.Date.valueOf(device.getPurchaseDate()) : null);
            stmt.setString(4, device.getSupplier());
            stmt.setBigDecimal(5, device.getPrice());
            stmt.setString(6, device.getStatus().name());
            stmt.setString(7, device.getRoom() != null ? device.getRoom().getId() : null);
            stmt.setInt(8, device.getQuantity());
            stmt.setBoolean(9, false);
            stmt.executeUpdate();
        }
    }

    public void updateDevice(Device device) throws SQLException {
        String sql = "UPDATE devices SET device_name = ?, device_type = ?, purchase_date = ?, supplier = ?, price = ?, status = ?, room_id = ?, quantity = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, device.getDeviceName());
            stmt.setString(2, device.getDeviceType());
            stmt.setDate(3, device.getPurchaseDate() != null ? java.sql.Date.valueOf(device.getPurchaseDate()) : null);
            stmt.setString(4, device.getSupplier());
            stmt.setBigDecimal(5, device.getPrice());
            stmt.setString(6, device.getStatus().name());
            stmt.setString(7, device.getRoom() != null ? device.getRoom().getId() : null);
            stmt.setInt(8, device.getQuantity());
            stmt.setString(9, device.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteDevice(String deviceId) throws SQLException {
        String sql = "UPDATE devices SET deleted = TRUE WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviceId);
            stmt.executeUpdate();
        }
    }

    public List<Device> getAllDevices() throws SQLException {
        List<Device> devices = new ArrayList<>();
        String sql = """
            SELECT d.id, d.device_name, d.device_type, d.purchase_date, d.supplier, d.price, d.status, d.room_id, d.quantity,
                   r.room_id, r.status AS room_status, r.room_number, r.seating_capacity
            FROM devices d
            LEFT JOIN room r ON d.room_id = r.room_id
            WHERE d.deleted = FALSE
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Room room = null;
                if (rs.getString("room_id") != null) {
                    room = new Room();
                    room.setId(rs.getString("room_id"));
                    room.setStatus(RoomStatus.valueOf(rs.getString("room_status")));
                    room.setRoomNumber(rs.getString("room_number"));
                    room.setSeatingCapacity(rs.getInt("seating_capacity"));
                }

                Device device = new Device(
                    rs.getString("id"),
                    "",
                    rs.getString("device_name"),
                    rs.getString("device_type"),
                    rs.getDate("purchase_date") != null ? rs.getDate("purchase_date").toLocalDate() : null,
                    rs.getString("supplier"),
                    rs.getBigDecimal("price"),
                    DeviceStatus.valueOf(rs.getString("status")),
                    room,
                    rs.getInt("quantity")
                );
                devices.add(device);
            }
        }
        return devices;
    }

    public Device getDeviceById(String deviceId) throws SQLException {
        String sql = """
            SELECT d.id, d.device_name, d.device_type, d.purchase_date, d.supplier, d.price, d.status, d.room_id, d.quantity,
                   r.room_id, r.status AS room_status, r.room_number, r.seating_capacity
            FROM devices d
            LEFT JOIN room r ON d.room_id = r.room_id
            WHERE d.id = ? AND d.deleted = FALSE
        """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Room room = null;
                    if (rs.getString("room_id") != null) {
                        room = new Room();
                        room.setId(rs.getString("room_id"));
                        room.setStatus(RoomStatus.valueOf(rs.getString("room_status")));
                        room.setRoomNumber(rs.getString("room_number"));
                        room.setSeatingCapacity(rs.getInt("seating_capacity"));
                    }

                    return new Device(
                        rs.getString("id"),
                        "",
                        rs.getString("device_name"),
                        rs.getString("device_type"),
                        rs.getDate("purchase_date") != null ? rs.getDate("purchase_date").toLocalDate() : null,
                        rs.getString("supplier"),
                        rs.getBigDecimal("price"),
                        DeviceStatus.valueOf(rs.getString("status")),
                        room,
                        rs.getInt("quantity")
                    );
                }
            }
        }
        return null;
    }
}