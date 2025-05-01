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
import Model.RoleName;
import Model.Status;
import Model.User;

public class ManagerUserRepository {
	
	public List<Role> getAllRoles() {
	    List<Role> roles = new ArrayList<>();
	    String query = "SELECT role_id, role_name FROM roles";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            int id = rs.getInt("role_id");
	            String name = rs.getString("role_name");
	            Role role = new Role(id, RoleName.valueOf(name));
	            roles.add(role);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return roles;
	}

	
	public int getRoleIdByRoleName(RoleName roleName) {
	    int roleId = -1;

	    String sql = "SELECT role_id FROM roles WHERE role_name = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, roleName.name());

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            roleId = rs.getInt("role_id"); 
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return roleId;
	}
	
	//Thêm mới người dùng 
	public String addUserAndReturnID(User user) {
		int roleId = getRoleIdByRoleName(user.getRole().getRoleName());
		String query = "INSERT INTO users (fullname, username, yearold, email, phoneNumber, password, status, role_id, thumbnail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setInt(8, roleId);
            stmt.setString(9, user.getThumbnail());
            
        
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
        String query = "SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.role_id WHERE u.deleted = false";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
        	
        	ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	String userId = rs.getString("user_id");
                String fullname = rs.getString("fullname");
                String username = rs.getString("username");
                String thumbnail = rs.getString("thumbnail");
                String yearold = rs.getString("yearold");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");
                String statusString = rs.getString("status");
                String roleString = rs.getString("role_name");
                
                Status status;
                status = Status.valueOf(statusString);
                
                RoleName roleName = RoleName.valueOf(roleString);
                Role role = new Role();
		        role.setRoleName(roleName);
                
                users.add(new Manager(fullname, username, thumbnail, yearold, email, phoneNumber, password, status, role, userId));
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
		String query = "UPDATE users SET fullname = ?, username = ?, yearold = ?, email = ?, phoneNumber = ?, status = ?, role_id = ?, thumbnail = ? WHERE user_id = ? AND deleted = false";
		try(Connection conn = DatabaseConnection.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setString(1, manager.getFullname());
			stmt.setString(2, manager.getUsername());
			stmt.setString(3, manager.getYearold());
			stmt.setString(4, manager.getEmail());
			stmt.setString(5, manager.getPhoneNumber());
			stmt.setString(6, manager.getStatus().name());
			stmt.setInt(7, manager.getRole().getRoleId());
			stmt.setString(8, manager.getThumbnail());
			stmt.setString(9, manager.getUserId());
			
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

//	Tìm kiếm người dùng
	public List<User> searchUsers(String[] keyword){
	    List<User> listUsers = new ArrayList<>();
	    StringBuilder sql = new StringBuilder("SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.role_id WHERE u.deleted = false");
	    for (String kw : keyword) {
	        sql.append(" AND LOWER(u.fullname) LIKE ?");
	    }
	    try(Connection conn = DatabaseConnection.getConnection();
	    	PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
	    	for (int i = 0; i < keyword.length; i++) {
	    	    stmt.setString(i + 1, "%" + keyword[i] + "%");
	    	}
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		    	String userId = rs.getString("user_id");
                String fullname = rs.getString("fullname");
                String username = rs.getString("username");
                String thumbnail = rs.getString("thumbnail");
                String yearold = rs.getString("yearold");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String password = rs.getString("password");
                String statusString = rs.getString("status");
                String roleString = rs.getString("role_name");
                
                Status status;
                status = Status.valueOf(statusString);
                
                RoleName roleName = RoleName.valueOf(roleString);
                Role role = new Role();
		        role.setRoleName(roleName);
                
		        listUsers.add(new Manager(fullname, username, thumbnail, yearold, email, phoneNumber, password, status, role, userId));
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return listUsers;
	}

}
