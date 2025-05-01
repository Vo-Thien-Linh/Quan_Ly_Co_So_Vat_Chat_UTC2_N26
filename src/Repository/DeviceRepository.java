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

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        String sql = "SELECT d.id, d.device_name, d.device_type, d.purchase_date, d.supplier, d.price, " +
                     "d.status, d.room_id, d.quantity, d.created_at, d.updated_at, d.deleted, " +
                     "r.room_id, r.room_number, r.status AS room_status, r.seating_capacity " +
                     "FROM devices d " +
                     "LEFT JOIN room r ON d.room_id = r.room_id " +
                     "WHERE d.deleted = FALSE";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Device device = new Device();
                device.setId(rs.getString("id"));
                device.setDeviceName(rs.getString("device_name"));
                device.setDeviceType(rs.getString("device_type"));
                device.setPurchaseDate(rs.getDate("purchase_date") != null ? rs.getDate("purchase_date").toLocalDate() : null);
                device.setSupplier(rs.getString("supplier"));
                device.setPrice(rs.getBigDecimal("price"));
                device.setStatus(DeviceStatus.valueOf(rs.getString("status")));
                device.setQuantity(rs.getInt("quantity"));
                device.setCreatedAt(rs.getTimestamp("created_at") != null ? rs.getTimestamp("created_at").toLocalDateTime().toLocalDate() : null);
                device.setUpdatedAt(rs.getTimestamp("updated_at") != null ? rs.getTimestamp("updated_at").toLocalDateTime().toLocalDate() : null);
                device.setDeleted(rs.getBoolean("deleted"));

                Room room = new Room();
                room.setId(rs.getString("room_id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setStatus(rs.getString("room_status") != null ? RoomStatus.valueOf(rs.getString("room_status")) : null);
                room.setSeatingCapacity(rs.getInt("seating_capacity"));
                device.setRoom(room);

                devices.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }

    public Boolean addDeviceAndReturnId(Device device) {
        String sql = "INSERT INTO devices (id, device_name, device_type, purchase_date, supplier, price, status, room_id, quantity, created_at, updated_at, deleted) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String newId = generateNewDeviceId();
            stmt.setString(1, newId);
            stmt.setString(2, device.getDeviceName());
            stmt.setString(3, device.getDeviceType());
            stmt.setDate(4, device.getPurchaseDate() != null ? java.sql.Date.valueOf(device.getPurchaseDate()) : null);
            stmt.setString(5, device.getSupplier());
            stmt.setBigDecimal(6, device.getPrice());
            stmt.setString(7, device.getStatus().name());
            stmt.setString(8, device.getRoom() != null ? device.getRoom().getId() : null);
            stmt.setInt(9, device.getQuantity());
            stmt.setTimestamp(10, device.getCreatedAt() != null ? java.sql.Timestamp.valueOf(device.getCreatedAt().atStartOfDay()) : null);
            stmt.setTimestamp(11, device.getUpdatedAt() != null ? java.sql.Timestamp.valueOf(device.getUpdatedAt().atStartOfDay()) : null);
            stmt.setBoolean(12, device.isDeleted());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean edit(Device device) {
        String sql = "UPDATE devices SET device_name = ?, device_type = ?, purchase_date = ?, supplier = ?, price = ?, " +
                     "status = ?, room_id = ?, quantity = ?, updated_at = ?, deleted = ? WHERE id = ?";
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
            stmt.setTimestamp(9, java.sql.Timestamp.valueOf(LocalDate.now().atStartOfDay()));
            stmt.setBoolean(10, device.isDeleted());
            stmt.setString(11, device.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(String deviceId) {
        String sql = "UPDATE devices SET deleted = TRUE WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviceId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Device getDeviceById(String deviceId) {
        String sql = "SELECT d.id, d.device_name, d.device_type, d.purchase_date, d.supplier, d.price, " +
                     "d.status, d.room_id, d.quantity, d.created_at, d.updated_at, d.deleted, " +
                     "r.room_id, r.room_number, r.status AS room_status, r.seating_capacity " +
                     "FROM devices d " +
                     "LEFT JOIN room r ON d.room_id = r.room_id " +
                     "WHERE d.id = ? AND d.deleted = FALSE";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Device device = new Device();
                    device.setId(rs.getString("id"));
                    device.setDeviceName(rs.getString("device_name"));
                    device.setDeviceType(rs.getString("device_type"));
                    device.setPurchaseDate(rs.getDate("purchase_date") != null ? rs.getDate("purchase_date").toLocalDate() : null);
                    device.setSupplier(rs.getString("supplier"));
                    device.setPrice(rs.getBigDecimal("price"));
                    device.setStatus(DeviceStatus.valueOf(rs.getString("status")));
                    device.setQuantity(rs.getInt("quantity"));
                    device.setCreatedAt(rs.getTimestamp("created_at") != null ? rs.getTimestamp("created_at").toLocalDateTime().toLocalDate() : null);
                    device.setUpdatedAt(rs.getTimestamp("updated_at") != null ? rs.getTimestamp("updated_at").toLocalDateTime().toLocalDate() : null);
                    device.setDeleted(rs.getBoolean("deleted"));

                    Room room = new Room();
                    room.setId(rs.getString("room_id"));
                    room.setRoomNumber(rs.getString("room_number"));
                    room.setStatus(rs.getString("room_status") != null ? RoomStatus.valueOf(rs.getString("room_status")) : null);
                    room.setSeatingCapacity(rs.getInt("seating_capacity"));
                    device.setRoom(room);

                    return device;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String generateNewDeviceId() throws SQLException {
        String sql = "SELECT id FROM devices ORDER BY id DESC LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String lastId = rs.getString("id");
                int number = Integer.parseInt(lastId.substring(1)) + 1; // Bỏ "D" và tăng số
                return String.format("D%03d", number);
            } else {
                return "D001";
            }
        }
    }
}