package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.DatabaseConnection;
import Model.Admin;
import Model.Manager;
import Model.Role;
import Model.Status;
import Model.User;

public class ManagerUserRepository {
	//Thêm mới người dùng 
	public String addUserAndReturnID(User user) {
		String query = "INSERT INTO users (fullname, username, yearold, email, phoneNumber, password, status, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String userId = null;
        try (Connection conn = DatabaseConnection.getConnection(); 
        	PreparedStatement stmt = conn.prepareStatement(query)) {
        	stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getYearold());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getPassword());
            stmt.setString(7, user.getStatus().name());
            stmt.setString(8, user.getRole().name());
            
        
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                String query_2 = "SELECT user_id FROM users WHERE username = ?";
                try (PreparedStatement ps2 = conn.prepareStatement(query_2)) {
                    ps2.setString(1, user.getUsername());
                    ResultSet rs = ps2.executeQuery();
                    if (rs.next()) {
                        userId = rs.getString("user_id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

	    return userId;
	}

	
	public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE deleted = false";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
        	ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	String userId = rs.getString("user_id");
                String fullname = rs.getString("fullname");
                String username = rs.getString("username");
                String yearold = rs.getString("yearold");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");
                String statusString = rs.getString("status");
                String roleString = rs.getString("role");
                
                Status status;
                status = Status.valueOf(statusString);
                
                Role role;
                if ("MANAGER".equals(roleString)) {
                    continue; 
                } else {
                    try {
                        role = Role.valueOf(roleString);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid role: " + roleString);
                        role = null; 
                    }
                }
                
                users.add(new Manager(fullname, username, yearold, email, phoneNumber, password, status, role, userId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
	
	 public boolean isUsernameExists(String userId, String username) {
			String query = "SELECT user_id FROM users WHERE username = ? AND user_id != ?";
			try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(query)) {
		        stmt.setString(1, username);
		        stmt.setString(2, userId);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	   }
	 
	 public boolean isEmailExists(String userId, String email) {
	    	String query = "SELECT * FROM users WHERE email = ? AND user_id != ?";
			try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(query)) {
		        stmt.setString(1, email);
		        stmt.setString(2, userId);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 public boolean isNumberPhoneExists(String userId, String phoneNumber) {
	    	String query = "SELECT * FROM users WHERE phoneNumber = ? AND user_id != ?";
			try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(query)) {
		        stmt.setString(1, phoneNumber);
		        stmt.setString(2, userId);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	
//	Chỉnh sửa người dùng
	public String edit(User manager) {
		String query = "UPDATE users SET fullname = ?, username = ?, yearold = ?, email = ?, phoneNumber = ?, status = ?, role = ? WHERE user_id = ? AND deleted = false";
		try(Connection conn = DatabaseConnection.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setString(1, manager.getFullname());
			stmt.setString(2, manager.getUsername());
			stmt.setString(3, manager.getYearold());
			stmt.setString(4, manager.getEmail());
			stmt.setString(5, manager.getPhoneNumber());
			stmt.setString(6, manager.getStatus().name());
			stmt.setString(7, manager.getRole().name());
			stmt.setString(8, manager.getUserId());
			
			int result = stmt.executeUpdate();
			
			if(result > 0) {
				return "SUCCESS";
			} else {
				return "UNSUCCESS";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "UNSUCCESS";
	}
	
//	xóa người dùng
	public Boolean delete(String userId) {
		String query = "UPDATE users SET deleted = true WHERE user_id = ?";
		try(Connection conn = DatabaseConnection.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, userId);
			
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
