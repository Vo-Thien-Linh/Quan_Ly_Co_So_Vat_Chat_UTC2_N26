package Repository;

import Config.DatabaseConnection;
import Model.Admin;
import Model.Role;
import Model.User;
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
            ResultSet rs = stmt.executeQuery();
            return rs.next();
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
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
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
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	
	public boolean addUser(User user) {
        String query = "INSERT INTO users (fullname, username, yearold, email, phoneNumber, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); 
        	PreparedStatement stmt = conn.prepareStatement(query)) {
        	stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getYearold());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getPassword());
            stmt.setString(7, user.getRole().name());
            
        
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
    public String[] getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? AND deleted = false";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	String password = rs.getString("password");
            	String status = rs.getString("status");
            	String role = rs.getString("role");
            	
                return new String[] { password, status, role };
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
