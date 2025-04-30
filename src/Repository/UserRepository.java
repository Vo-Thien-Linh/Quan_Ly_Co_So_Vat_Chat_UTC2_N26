package Repository;

import Config.DatabaseConnection;
import Model.Admin;
import Model.Manager;
import Model.Role;
import Model.RoleName;
import Model.User;
import Model.Session;
import Model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserRepository {
	public boolean checkUsernameExists(String username) {
		String query = "SELECT * FROM users WHERE username = ? AND deleted = false";
		try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmailExists(String email) {
    	String query = "SELECT * FROM users WHERE email = ? AND deleted = false";
		try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, email);
	        try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkNumberPhoneExists(String phoneNumber) {
    	String query = "SELECT * FROM users WHERE phoneNumber = ? AND deleted = false";
		try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, phoneNumber);
	        try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
//	public boolean addUser(User user) {
//        String query = "INSERT INTO users (fullname, username, yearold, email, phoneNumber, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (Connection conn = DatabaseConnection.getConnection(); 
//        	PreparedStatement stmt = conn.prepareStatement(query)) {
//        	stmt.setString(1, user.getFullname());
//            stmt.setString(2, user.getUsername());
//            stmt.setString(3, user.getYearold());
//            stmt.setString(4, user.getEmail());
//            stmt.setString(5, user.getPhoneNumber());
//            stmt.setString(6, user.getPassword());
//            stmt.setString(7, user.getRole().name());
//            
//        
//            int rowsInserted = stmt.executeUpdate();
//            return rowsInserted > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
	
    public String[] getUserByUsername(String username) {
    	String query = """
    	        SELECT u.user_id, u.password, u.status, r.role_name 
    	        FROM users u 
    	        JOIN roles r ON u.role_id = r.role_id 
    	        WHERE u.username = ? AND u.deleted = false
    	    """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	Session.setUserId(rs.getString("user_id"));
                    String password = rs.getString("password");
                    String status = rs.getString("status");
                    String roleName = rs.getString("role_name");
                    Session.setRole(roleName);
                    return new String[]{password, status};
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User getInforUser(String userId) {
    	String query = "SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.role_id WHERE u.user_id = ? AND u.deleted = false";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String username = rs.getString("username");
                    String thumbnail = rs.getString("thumbnail");
                    String yearold = rs.getString("yearold");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phoneNumber");
                    String statusString = rs.getString("status");
                    String roleString = rs.getString("role_name");
                    
                    Status status;
                    status = Status.valueOf(statusString);
                    
                    RoleName roleName = RoleName.valueOf(roleString);
                    Role role = new Role();
    		        role.setRoleName(roleName);
                    
                    return new Manager(fullname, username, thumbnail, yearold, email, phoneNumber, null, status, role, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
