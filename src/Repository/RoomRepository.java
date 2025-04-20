package Repository;

import Config.DatabaseConnection;
import Model.Room;
import Model.RoomStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO room (room_id, room_number, seating_capacity, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getId());
            stmt.setString(2, room.getRoomNumber());
            stmt.setInt(3, room.getSeatingCapacity());
            stmt.setString(4, room.getStatus().name());
            stmt.executeUpdate();
        }
    }

    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE room SET room_number = ?, seating_capacity = ?, status = ? WHERE room_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getRoomNumber());
            stmt.setInt(2, room.getSeatingCapacity());
            stmt.setString(3, room.getStatus().name()); // Sửa lỗi: dùng name() để lấy String
            stmt.setString(4, room.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteRoom(String roomId) throws SQLException {
        String sql = "DELETE FROM room WHERE room_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, roomId);
            stmt.executeUpdate();
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM room";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RoomStatus status;
                try {
                    status = RoomStatus.valueOf(rs.getString("status"));
                } catch (IllegalArgumentException e) {
                    status = RoomStatus.AVAILABLE; // Giá trị mặc định
                }
                Room room = new Room(
                    rs.getString("room_id"),
                    status,
                    rs.getString("room_number"),
                    rs.getInt("seating_capacity")
                );
                rooms.add(room);
            }
        }
        return rooms;
    }

    public void updateRoomStatus(String roomId, RoomStatus status) throws SQLException {
        String sql = "UPDATE room SET status = ? WHERE room_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setString(2, roomId);
            stmt.executeUpdate();
        }
    }
}