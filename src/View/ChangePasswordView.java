package View;

import javax.swing.*;

import Controller.UserController;
import utils.PasswordEncryptionUtils;
import utils.ScannerUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;

public class ChangePasswordView extends JFrame {
	private LoginView loginView;
	private UserController controller = new UserController(loginView);
	private String email;
	
	public ChangePasswordView(String email) {
	    this.email = email;
	    initUI(); 
	}
	
    public void initUI() {
        setTitle("Đổi mật khẩu");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true); 

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(245, 250, 255));
        mainPanel.setLayout(new BorderLayout(0, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));


        JLabel titleLabel = new JLabel("Đổi mật khẩu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(50, 50, 50));

        JPanel formPanel = new JPanel();
        formPanel.setBackground(mainPanel.getBackground());
        formPanel.setLayout(new GridLayout(4, 1, 8, 8));

        JLabel newPassLabel = new JLabel("Mật khẩu mới:");
        JPasswordField newPasswordField = new JPasswordField();
        newPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel confirmPassLabel = new JLabel("Xác nhận mật khẩu:");
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        formPanel.add(newPassLabel);
        formPanel.add(newPasswordField);
        formPanel.add(confirmPassLabel);
        formPanel.add(confirmPasswordField);

        // Nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(mainPanel.getBackground());

        JButton backButton = new JButton("Trở lại");
        backButton.setBackground(new Color(220, 220, 220));
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setPreferredSize(new Dimension(100, 35));

        backButton.addActionListener(e -> {
            new ForgotPasswordView().setVisible(true); 
            dispose();
        });

        JButton submitButton = new JButton("Xác nhận");
        submitButton.setBackground(new Color(60, 130, 230));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setPreferredSize(new Dimension(120, 35));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                	ScannerUtils.showErrorMessage(ChangePasswordView.this, "Vui lòng điền đầy đủ thông tin!");
                } else if (!newPassword.equals(confirmPassword)) {
                	ScannerUtils.showErrorMessage(ChangePasswordView.this, "Mật khẩu không khớp.");
                } else {
                	confirmPassword = PasswordEncryptionUtils.hashPassword(confirmPassword);
                    Boolean success = controller.changePassword(confirmPassword, email);
                    if(success) {
                    	ScannerUtils.showConfirmMessage(ChangePasswordView.this, "Đổi mật khẩu thành công!");
                    	new LoginView().setVisible(true); 
                        dispose();
                    }
                }
            }
        });

        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

}
