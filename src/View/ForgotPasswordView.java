package View;

import javax.swing.*;

import Controller.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.LoginView;
import utils.ScannerUtils;

public class ForgotPasswordView extends JFrame {
	private LoginView loginView;
	private UserController controller = new UserController(loginView);
	
    public ForgotPasswordView() {
        setTitle("Quên mật khẩu");
        setSize(400, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true); // bỏ khung mặc định

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setLayout(new BorderLayout(0, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Tiêu đề
        JLabel titleLabel = new JLabel("Quên mật khẩu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(50, 50, 50));

        // Nhập email
        JPanel formPanel = new JPanel();
        formPanel.setBackground(mainPanel.getBackground());
        formPanel.setLayout(new GridLayout(2, 1, 5, 5));

        JLabel emailLabel = new JLabel("Nhập email của bạn:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        formPanel.add(emailLabel);
        formPanel.add(emailField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(mainPanel.getBackground());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));

        JButton submitButton = new JButton("Gửi yêu cầu");
        submitButton.setBackground(new Color(100, 149, 237));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setPreferredSize(new Dimension(130, 35));
        
//        bắt sự nút gửi yêu cầu
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText().trim();
                boolean success = controller.forgotPassword(email);
                if(success) {
                	dispose();
                	new ChangePasswordView(email).setVisible(true);
                } else {
                	ScannerUtils.showErrorMessage(ForgotPasswordView.this, "Email không tồn tại!");
                }
            }
        });

        // Nút trở lại
        JButton backButton = new JButton("Trở lại");
        backButton.setBackground(new Color(220, 220, 220));
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setPreferredSize(new Dimension(100, 35));

        backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginView().setVisible(true);
			}
		}); 

        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);

        // Thêm các thành phần vào mainPanel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
