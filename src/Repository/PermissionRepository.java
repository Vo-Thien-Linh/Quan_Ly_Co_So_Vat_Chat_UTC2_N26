package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Config.DatabaseConnection;
import Model.Session;

public class PermissionRepository {
	 public Map<String, Boolean[]> loadPermissionData() {
	        Map<String, Boolean[]> permissionMap = new HashMap<>();

	        String query = """
	            SELECT
	                f.name AS function_name,
	                r.role_name AS role_name,
	                pt.name AS permission_type,
	                p.allowed
	            FROM permissions p
	            JOIN roles r ON p.role_id = r.role_id
	            JOIN functions f ON p.function_id = f.id
	            JOIN permission_types pt ON p.permission_type_id = pt.id
	        """;

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                String function = rs.getString("function_name");
	                String role = rs.getString("role_name");
	                String permissionType = rs.getString("permission_type");
	                boolean allowed = rs.getBoolean("allowed");
	                
	                if(role.equals("MAINTENANCE")) {
	                	role = "Bảo trì";
	                } else if(role.equals("LECTURER")){
	                	role = "Giáo viên";
	                } else if(role.equals("ADMIN")) {
	                	role = "Quản trị viên";
	                }
	                
	                String key = function + "_" + role;
	                Boolean[] permissions = permissionMap.getOrDefault(key, new Boolean[]{false, false, false, false});

	                switch (permissionType) {
	                    case "view" -> permissions[0] = allowed;
	                    case "add" -> permissions[1] = allowed;
	                    case "edit" -> permissions[2] = allowed;
	                    case "delete" -> permissions[3] = allowed;
	                }

	                permissionMap.put(key, permissions);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return permissionMap;
	    }
	 
	 public int getRoleIdByName(String roleName) {
	        String sql = "SELECT role_id FROM roles WHERE role_name = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, roleName);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("role_id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return -1; 
	    }
	 
	 public int getFunctionIdByName(String functionName) {
	        String sql = "SELECT id FROM functions WHERE name = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, functionName);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return -1;
	    }
	 
	 public void updatePermission(int roleId, int functionId, int permissionTypeId, boolean allowed) {
	        String sql = "REPLACE INTO permissions (role_id, function_id, permission_type_id, allowed) VALUES (?, ?, ?, ?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, roleId);
	            stmt.setInt(2, functionId);
	            stmt.setInt(3, permissionTypeId);
	            stmt.setBoolean(4, allowed);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 

	 public Map<String, Boolean[]> getPermissionsByUserId() {
		    Map<String, Boolean[]> permissionsMap = new HashMap<>();

		    try (Connection conn = DatabaseConnection.getConnection()) {
		        String roleName = Session.getRole(); 

		        if (roleName == null) return permissionsMap;

		        String sql = """
		            SELECT f.name AS function_name,
		                   pt.name AS permission_type,
		                   p.allowed
		            FROM permissions p
		            JOIN functions f ON p.function_id = f.id
		            JOIN permission_types pt ON p.permission_type_id = pt.id
		            JOIN roles r ON p.role_id = r.role_id
		            WHERE r.role_name = ?  -- Lọc theo tên vai trò từ Session
		        """;
		        
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setString(1, roleName); 
		        ResultSet rs = stmt.executeQuery();

		        while (rs.next()) {
		            String functionName = rs.getString("function_name");
		            String permissionType = rs.getString("permission_type").toLowerCase();
		            boolean allowed = rs.getBoolean("allowed");

		            String key = functionName + "_" + roleName;
		            Boolean[] rights = permissionsMap.getOrDefault(key, new Boolean[]{false, false, false, false});

		            switch (permissionType) {
		                case "view" -> rights[0] = allowed;
		                case "add" -> rights[1] = allowed;
		                case "edit" -> rights[2] = allowed;
		                case "delete" -> rights[3] = allowed;
		            }

		            permissionsMap.put(key, rights);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return permissionsMap;
		}

}
