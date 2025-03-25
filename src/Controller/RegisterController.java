package controller;

import model.User;
import service.UserService;
import model.Role;
import dao.UserDAO;
import view.LoginView;
import view.RegisterView;

public class RegisterController {
	private RegisterView registerView;
    private UserService userService;

    public RegisterController(RegisterView registerView) {
        this.registerView = registerView;
        this.userService = new UserService();
    }

    public void register(String username, int yearold, String email, String phoneNumber, String password, Role role) {
    	if (userService.isUsernameExists(username)) {
    		registerView.showErrorMessage("Tên đăng nhập đã tồn tại!");
            return;
        }
        if (userService.isEmailExists(email)) {
        	registerView.showErrorMessage("Email đã được sử dụng!");
            return;
        }
        
        if(userService.isNumberPhoneExists(phoneNumber)) {
        	registerView.showErrorMessage("Số điện thoại đã được sử dụng!");
            return;
        }
    	
    	User user = new User(username, yearold, email, phoneNumber, password, role);

        boolean isRegistered = userService.registerUser(user);
        if (isRegistered) {
            registerView.showSuccessMessage("Đăng ký thành công!");
            new LoginView().setVisible(true);
            registerView.dispose();
        } else {
            registerView.showErrorMessage("Đăng ký không thành công!");
        }
    }
}
