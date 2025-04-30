package Controller;

import java.util.Map;

import com.mysql.cj.PerConnectionLRUFactory;

import Repository.PermissionRepository;

public class PermissionController {
	private PermissionRepository permissionRepository = new PermissionRepository();
	
	public Map<String, Boolean[]> loadPermissionData(){
		return permissionRepository.loadPermissionData();
	}
	
	public int getRoleIdByName(String roleName) {
		return permissionRepository.getRoleIdByName(roleName);
	}
	
	public int getFunctionIdByName(String functionName) {
		return permissionRepository.getFunctionIdByName(functionName);
	}
	
	public void updatePermission(int roleId, int functionId, int permissionTypeId, boolean allowed) {
		permissionRepository.updatePermission(roleId, functionId, permissionTypeId, allowed);
    }
	
	public Map<String, Boolean[]> getPermissionsByUserId(){
		return permissionRepository.getPermissionsByUserId();
	}
}
