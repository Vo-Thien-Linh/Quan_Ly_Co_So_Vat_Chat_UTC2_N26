package Controller;

import Service.UserService;
import View.LoginView;
import View.PageManager;
import utils.PermissionUtils;
import utils.ScannerUtils;
import Model.Admin;
import Model.RoleName;
import Model.Status;
import Model.User;
import Repository.UserRepository;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.cloudinary.provisioning.Account.Role;

public class UserController {
	private UserRepository userRepository = new UserRepository();
    private LoginView loginView;
    private PermissionController permissionController = new PermissionController();
    
    public UserController(LoginView loginView) {
        this.loginView = loginView;
    }

//    Tinh nang dang nhap
    public void login(String username, String password) {
    	UserService userService = new UserService();
        String success = userService.login(username, password);

        if (success == "SUCCESS") {
        	ScannerUtils.showSuccessMessage(loginView, "Đăng nhập thành công!");
        	Map<String, Boolean[]> permissionMap = permissionController.getPermissionsByUserId();
            PermissionUtils.setPermissionMap(permissionMap);
        	loginView.setVisible(false);
        	
        	PageManager pageManager = new PageManager();
        	pageManager.setVisible(true);
        } else if(success == "UNSUCCESS"){
            ScannerUtils.showErrorMessage(loginView, "Sai tài khoản hoặc mật khẩu!");
        } else if(success == "INACTIVE") {
        	ScannerUtils.showErrorMessage(loginView, "Tài khoản đã bị khóa!");
        } else if(success == "NOTEXIST") {
        	ScannerUtils.showErrorMessage(loginView, "Tài khoản không tồn tại!");
        } else {
        	ScannerUtils.showErrorMessage(loginView, "Tài khoản đang bảo trì!");
        }
    }
    
    
    //Tinh nang dang xuat
    public static void logout(JFrame currentFrame) {
		int choice = ScannerUtils.showConfirmMessage(currentFrame, "Bạn có chắc chắn muốn đăng xuất?");
		
		if(choice == JOptionPane.YES_NO_OPTION) {
			currentFrame.setVisible(false); 
	        new LoginView().setVisible(true);
		}
    }
    
//    tinh nang quen mat khau
    public boolean forgotPassword(String email) {
		return userRepository.forgotPassword(email);
	}
    
    public boolean changePassword(String pasword, String email) {
		return userRepository.changePassword(pasword, email);
	}
    
    public User getInforUser(String userId) {
    	return userRepository.getInforUser(userId);
    }
}
