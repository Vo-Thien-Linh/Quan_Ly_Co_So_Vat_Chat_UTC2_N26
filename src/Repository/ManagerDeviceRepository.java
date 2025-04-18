package Repository;

import java.sql.Statement;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.DatabaseConnection;
import Model.Device;
import Model.DeviceStatus;
import Model.Room;

public class ManagerDeviceRepository {
	public static ArrayList<Room> getAllRooms(){
		ArrayList<Room> rooms = new ArrayList<>();
		String query = "SELECT id, room_number FROM rooms WHERE status = 'AVAILABLE'";
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query)) {
			
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String roomId = result.getString("id");
				String roomNumber = result.getString("room_number");
				rooms.add(new Room(roomId, roomNumber));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}
	
	public static Boolean addDeviceAndReturnId(Device device) {
		String query = "INSERT INTO devices (device_name, device_type, purchase_date, supplier, price, status, room_id, quantity, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setString(1, device.getDeviceName());
			stmt.setString(2, device.getDeviceType());
			stmt.setDate(3, Date.valueOf(device.getPurchaseDate()));
			stmt.setString(4, device.getSupplier());
			stmt.setBigDecimal(5, device.getPrice());
			stmt.setString(6, device.getStatus().name());
			stmt.setString(7, device.getRoom().getId());
			stmt.setInt(8, device.getQuantity());
			stmt.setDate(9, Date.valueOf(device.getCreatedAt()));
			stmt.setDate(10, Date.valueOf(device.getUpdatedAt()));
			
			int resultSet = stmt.executeUpdate();
			if(resultSet > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static Room findById(Connection conn, String roomId) throws SQLException {
		String query = "SELECT room_number FROM rooms WHERE id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, roomId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Room(roomId, rs.getString("room_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<Device> getAllDevices() {
		List<Device> devices = new ArrayList<>();
		String query = "SELECT * FROM devices WHERE deleted = false";
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query)) {
			
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String deviceId = result.getString("id");
				String deviceName = result.getString("device_name");
				String deviceType = result.getString("device_type");
				LocalDate purchaseDate = result.getDate("purchase_date").toLocalDate();
				String supplier = result.getString("supplier");
				BigDecimal price = result.getBigDecimal("price");
				String statusStr = result.getString("status");
				String roomId = result.getString("room_id");
				int quantity = result.getInt("quantity");
				
				DeviceStatus status = DeviceStatus.valueOf(statusStr);
				
				 Room room = findById(conn, roomId);
				
				devices.add(new Device(deviceId, deviceName, deviceType, purchaseDate, supplier, price, status, room, quantity));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devices;
	}
	
	public static boolean edit(Device device) {
		String query = "UPDATE devices SET device_name = ?, device_type = ?, purchase_date = ?, supplier = ?, price = ?, status = ?, room_id = ?, quantity = ?, updated_at = ? WHERE id = ? AND deleted = false";
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, device.getDeviceName());
			stmt.setString(2, device.getDeviceType());
			stmt.setDate(3, Date.valueOf(device.getPurchaseDate()));
			stmt.setString(4, device.getSupplier());
			stmt.setBigDecimal(5, device.getPrice());
			stmt.setString(6, device.getStatus().name());
			stmt.setString(7, device.getRoom().getId());
			stmt.setInt(8, device.getQuantity());
			stmt.setDate(9, Date.valueOf(device.getUpdatedAt()));
			stmt.setString(10, device.getId());
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean delete(String deviceId) {
		String query = "UPDATE devices SET deleted = true WHERE id = ?";
		try(Connection conn = DatabaseConnection.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, deviceId);
			
			int result = stmt .executeUpdate();
			if(result > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
