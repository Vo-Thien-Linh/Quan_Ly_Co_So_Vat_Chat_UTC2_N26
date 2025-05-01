package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import Config.DatabaseConnection;
import Model.Device;
import Model.DeviceStatus;
import Model.Room;
import Model.RoomStatus;

public class ManagerDeviceRepository {

    public static ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        String query = "SELECT room_id, room_number, status, seating_capacity FROM room WHERE status = 'AVAILABLE'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet result = stmt.executeQuery()) {
            while (result.next()) {
                Room room = new Room();
                room.setId(result.getString("room_id"));
                room.setRoomNumber(result.getString("room_number"));
                room.setStatus(RoomStatus.valueOf(result.getString("status")));
                room.setSeatingCapacity(result.getInt("seating_capacity"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static Boolean addDeviceAndReturnId(Device device) {
        String query = "INSERT INTO devices (device_name, device_type, purchase_date, supplier, price, status, room_id, quantity, created_at, updated_at, deleted) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, device.getDeviceName());
            stmt.setString(2, device.getDeviceType());
            stmt.setDate(3, device.getPurchaseDate() != null ? java.sql.Date.valueOf(device.getPurchaseDate()) : null);
            stmt.setString(4, device.getSupplier());
            stmt.setBigDecimal(5, device.getPrice());
            stmt.setString(6, device.getStatus().name());
            stmt.setString(7, device.getRoom() != null ? device.getRoom().getId() : null);
            stmt.setInt(8, device.getQuantity());
            stmt.setTimestamp(9, device.getCreatedAt() != null ? java.sql.Timestamp.valueOf(device.getCreatedAt().atStartOfDay()) : null);
            stmt.setTimestamp(10, device.getUpdatedAt() != null ? java.sql.Timestamp.valueOf(device.getUpdatedAt().atStartOfDay()) : null);
            stmt.setBoolean(11, false); // deleted = false khi thêm mới

            int resultSet = stmt.executeUpdate();
            if (resultSet > 0) {
                // Lấy ID tự động sinh từ trigger
                String newId = getLastInsertedDeviceId(conn);
                device.setId(newId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Room findById(Connection conn, String roomId) throws SQLException {
        String query = "SELECT room_id, room_number, status, seating_capacity FROM room WHERE room_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roomId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setId(rs.getString("room_id"));
                room.setRoomNumber(rs.getString("room_number"));
                room.setStatus(RoomStatus.valueOf(rs.getString("status")));
                room.setSeatingCapacity(rs.getInt("seating_capacity"));
                return room;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        String query = "SELECT d.id, d.device_name, d.device_type, d.purchase_date, d.supplier, d.price, " +
                      "d.status, d.room_id, d.quantity, d.created_at, d.updated_at, d.deleted " +
                      "FROM devices d WHERE d.deleted = FALSE";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet result = stmt.executeQuery()) {
            while (result.next()) {
                String deviceId = result.getString("id");
                LocalDate createdAt = result.getTimestamp("created_at") != null ? result.getTimestamp("created_at").toLocalDateTime().toLocalDate() : null;
                LocalDate updatedAt = result.getTimestamp("updated_at") != null ? result.getTimestamp("updated_at").toLocalDateTime().toLocalDate() : null;
                String deviceName = result.getString("device_name");
                String deviceType = result.getString("device_type");
                LocalDate purchaseDate = result.getDate("purchase_date") != null ? result.getDate("purchase_date").toLocalDate() : null;
                String supplier = result.getString("supplier");
                BigDecimal price = result.getBigDecimal("price");
                DeviceStatus status = DeviceStatus.valueOf(result.getString("status"));
                String roomId = result.getString("room_id");
                int quantity = result.getInt("quantity");
                boolean deleted = result.getBoolean("deleted");

                Room room = findById(conn, roomId);

                Device device = new Device(deviceId, createdAt, updatedAt, deviceName, deviceType, purchaseDate, supplier, price, status, room, quantity, deleted);
                devices.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }

    public static Device getDeviceById(String deviceId) {
        String query = "SELECT d.id, d.device_name, d.device_type, d.purchase_date, d.supplier, d.price, " +
                      "d.status, d.room_id, d.quantity, d.created_at, d.updated_at, d.deleted " +
                      "FROM devices d WHERE d.id = ? AND d.deleted = FALSE";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, deviceId);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                LocalDate createdAt = result.getTimestamp("created_at") != null ? result.getTimestamp("created_at").toLocalDateTime().toLocalDate() : null;
                LocalDate updatedAt = result.getTimestamp("updated_at") != null ? result.getTimestamp("updated_at").toLocalDateTime().toLocalDate() : null;
                String deviceName = result.getString("device_name");
                String deviceType = result.getString("device_type");
                LocalDate purchaseDate = result.getDate("purchase_date") != null ? result.getDate("purchase_date").toLocalDate() : null;
                String supplier = result.getString("supplier");
                BigDecimal price = result.getBigDecimal("price");
                DeviceStatus status = DeviceStatus.valueOf(result.getString("status"));
                String roomId = result.getString("room_id");
                int quantity = result.getInt("quantity");
                boolean deleted = result.getBoolean("deleted");

                Room room = findById(conn, roomId);

                return new Device(deviceId, createdAt, updatedAt, deviceName, deviceType, purchaseDate, supplier, price, status, room, quantity, deleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean edit(Device device) {
        String query = "UPDATE devices SET device_name = ?, device_type = ?, purchase_date = ?, supplier = ?, price = ?, " +
                      "status = ?, room_id = ?, quantity = ?, updated_at = ?, deleted = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
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

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(String deviceId) {
        String query = "UPDATE devices SET deleted = TRUE WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, deviceId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String getLastInsertedDeviceId(Connection conn) throws SQLException {
        String sql = "SELECT id FROM devices ORDER BY created_at DESC LIMIT 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("id");
            }
        }
        return null;
    }
}