package Controller;

import Model.User;
<<<<<<< HEAD
import Service.UserService;
import Model.Role;
import Dao.UserDAO;
import View.LoginView;
import View.RegisterView;
=======
import Repository.UserRepository;
import Service.UserService;
import View.LoginView;
import View.RegisterView;
import Model.Admin;
import Model.Role;
>>>>>>> Tinh-nang-dang-nhap

public class RegisterController {
	private RegisterView registerView;
    private UserService userService;

    public RegisterController(RegisterView registerView) {
        this.registerView = registerView;
        this.userService = new UserService();
    }

    public void register(String username, String yearold, String email, String phoneNumber, String password, Role role) {
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
    	
    	User admin = new Admin(username, yearold, email, phoneNumber, password, role);

        boolean isRegistered = userService.registerUser(admin);
        if (isRegistered) {
            registerView.showSuccessMessage("Đăng ký thành công!");
            new LoginView().setVisible(true);
            registerView.dispose();
        } else {
            registerView.showErrorMessage("Đăng ký không thành công!");
        }
    }
}
