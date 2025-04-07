package Controller;

import Service.UserService;
import View.LoginView;
import View.PageManager;
import View.RegisterView;
import utils.ScannerUtils;
import Model.Admin;
import Model.Role;
import Model.Status;
import Model.User;
import Repository.UserRepository;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserController {
	private UserRepository userRepository;
    private LoginView loginView;
    private RegisterView registerView;
    
    public UserController(LoginView loginView, RegisterView registerView) {
        this.loginView = loginView;
        this.registerView = registerView;
    }
    
//    Tinh nang dang ky
    public void register(String fullname, String username, String yearold, String email, String phoneNumber, String password, Role role) {
    	userRepository = new UserRepository();
    	if (userRepository.checkUsernameExists(username)) {
    		ScannerUtils.showErrorMessage(registerView, "Tên đăng nhập đã tồn tại!");
            return;
        }
        if (userRepository.checkEmailExists(email)) {
        	ScannerUtils.showErrorMessage(registerView, "Email đã được sử dụng!");
            return;
        }
        
        if(userRepository.checkNumberPhoneExists(phoneNumber)) {
        	ScannerUtils.showErrorMessage(registerView, "Số điện thoại đã được sử dụng!");
            return;
        }
    	
    	User admin = new Admin(fullname, username, yearold, email, phoneNumber, password, Status.ACTIVE, role);

        boolean isRegistered = userRepository.addUser(admin);
        if (isRegistered) {
        	ScannerUtils.showSuccessMessage(registerView, "Đăng ký thành công!");
            new LoginView().setVisible(true);
            registerView.dispose();
        } else {
        	ScannerUtils.showErrorMessage(registerView, "Đăng ký không thành công!");
        }
    }

//    Tinh nang dang nhap
    public void login(String username, String password) {
    	UserService userService = new UserService();
        String success = userService.login(username, password);

        if (success == "SUCCESS") {
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
    
    public void showRegister() {
        new RegisterView().setVisible(true);
        loginView.dispose(); 
    }
    
    
    //Tinh nang dang xuat
    public static void logout(JFrame currentFrame) {
		int choice = ScannerUtils.showConfirmMessage(currentFrame, "Bạn có chắc chắn muốn đăng xuất?");
		
		if(choice == JOptionPane.YES_NO_OPTION) {
			currentFrame.setVisible(false); 
	        new LoginView().setVisible(true);
		}
    }
    
}
