package Repository;

import Config.DatabaseConnection;
import Model.Room;
import Model.RoomStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO room (status, room_number, seating_capacity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getStatus().name());
            stmt.setString(2, room.getRoomNumber());
            stmt.setInt(3, room.getSeatingCapacity());
            stmt.executeUpdate();
        }
    }

    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE room SET status = ?, room_number = ?, seating_capacity = ? WHERE room_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getStatus().name());
            stmt.setString(2, room.getRoomNumber());
            stmt.setInt(3, room.getSeatingCapacity());
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
        String sql = "SELECT room_id, status, room_number, seating_capacity FROM room";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getString("room_id"));
                room.setStatus(RoomStatus.valueOf(rs.getString("status")));
                room.setRoomNumber(rs.getString("room_number"));
                room.setSeatingCapacity(rs.getInt("seating_capacity"));
                rooms.add(room);
            }
        }
        return rooms;
    }
}