package Controller;

import javax.swing.JOptionPane;

import Service.UserService;
import View.HomePage;
import View.LoginView;
import View.RegisterView;

public class LoginController {
    private UserService userService;
    private LoginView loginView;
    public LoginController(UserService userService, LoginView loginView) {
        this.userService = userService;
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        boolean success = userService.login(username, password);
        if (success) {
        	loginView.setVisible(false);
        	
        	HomePage homePage = new HomePage();
        	homePage.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(loginView, "Sai tài khoản hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void showRegister() {
        new RegisterView().setVisible(true);
        loginView.dispose(); 
    }
}
