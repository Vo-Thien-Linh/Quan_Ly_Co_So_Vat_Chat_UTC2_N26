package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Config.DatabaseConnection;
import Model.Admin;
import Model.Role;
import Model.Status;
import Model.User;
import Repository.ManagerUserRepository;
import Repository.UserRepository;
import Service.UserService;
import View.LoginView;
import View.RegisterView;
import utils.ScannerUtils;

public class ManagerUserController {
	private UserRepository userRepository;
	private ManagerUserRepository managerUserRepository;
    private LoginView loginView;
    private RegisterView registerView;
    
    public ManagerUserController(LoginView loginView, RegisterView registerView) {
        this.loginView = loginView;
        this.registerView = registerView;
    }
	
	public List<User> getAllUsers() {
    	managerUserRepository = new ManagerUserRepository();
        return managerUserRepository.getAllUsers();
    }
    
    public String addUserAndReturnID(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role) {;
	    userRepository = new UserRepository();
		if (userRepository.checkUsernameExists(username)) {
			ScannerUtils.showErrorMessage(registerView, "Tên đăng nhập đã tồn tại!");
	        return null;
	    }
	    if (userRepository.checkEmailExists(email)) {
	    	ScannerUtils.showErrorMessage(registerView, "Email đã được sử dụng!");
	    	return null;
	    }
	    
	    if(userRepository.checkNumberPhoneExists(phoneNumber)) {
	    	ScannerUtils.showErrorMessage(registerView, "Số điện thoại đã được sử dụng!");
	    	return null;
	    }
    	
	    
	    
    	User admin = new Admin(fullname, username, yearold, email, phoneNumber, password, status, role);
    	managerUserRepository = new ManagerUserRepository();
        String userId = managerUserRepository.addUserAndReturnID(admin);
        return userId;
    }
    
    public String edit(User manager) {
    	managerUserRepository = new ManagerUserRepository();
		if (managerUserRepository.isUsernameExists(manager.getUserId() ,manager.getUsername())) {
			ScannerUtils.showErrorMessage(registerView, "Tên đăng nhập đã tồn tại!");
	        return null;
	    }
		
		if(managerUserRepository.isNumberPhoneExists(manager.getUserId(), manager.getPhoneNumber())) {
		    	ScannerUtils.showErrorMessage(registerView, "Số điện thoại đã được sử dụng!");
		    	return null;
		 }
		 
	    if (managerUserRepository.isEmailExists(manager.getUserId(), manager.getEmail())) {
	    	ScannerUtils.showErrorMessage(registerView, "Email đã được sử dụng!");
	    	return null;
	    }
	    
	   
    
    	String editSuccess = managerUserRepository.edit(manager);
    	return editSuccess;
    }
    
    public boolean delete(String userId, JFrame currentFrame){
    	managerUserRepository = new ManagerUserRepository();
    	int choice = ScannerUtils.showConfirmMessage(currentFrame, "Bạn có chắc chắn muốn xóa?");
		
		if(choice == JOptionPane.YES_NO_OPTION) {
			Boolean deleteSuccess = managerUserRepository.delete(userId);
	    	return deleteSuccess;
		}
		
		return false;
    }
}
