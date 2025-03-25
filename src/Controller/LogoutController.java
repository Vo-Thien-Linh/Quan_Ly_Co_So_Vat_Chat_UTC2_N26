package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.LoginView;

public class LogoutController {	
	public static void logout(JFrame currentFrame) {
		int choice = JOptionPane.showConfirmDialog(currentFrame, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
		
		if(choice == JOptionPane.YES_NO_OPTION) {
			currentFrame.setVisible(false); 
	        new LoginView().setVisible(true);
		}
    }
}
