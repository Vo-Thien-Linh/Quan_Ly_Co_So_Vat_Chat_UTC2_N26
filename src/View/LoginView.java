package View;

import javax.swing.*;

import Controller.UserController;
import Service.UserService;
import utils.ScannerUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
	 private static final long serialVersionUID = 1L;
	    private JTextField textFieldID;
	    private JPasswordField passwordField;
	    private JCheckBox showPasswordCheckBox;

    public LoginView() {
    	setTitle("Quản lý cơ sở vật chất UTC2 - Đăng nhập");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/logo-utc.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(new Color(255, 255, 225));
        setContentPane(contentPane);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Tiêu đề
        JLabel lblTitle = new JLabel("QUẢN LÝ CƠ SỞ VẬT CHẤT UTC2", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 24));
        lblTitle.setForeground(new Color(0, 0, 128));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(lblTitle, gbc);
        
        // Logo
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/IMG/logo-utc.png"));
        Image img = originalIcon.getImage(); 
        Image resizedImg = img.getScaledInstance(300, 230, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(resizedImg);

        JLabel lblLogo = new JLabel(resizedIcon);
        gbc.gridy = 1;
        contentPane.add(lblLogo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(new JLabel("Tên Đăng nhập:", JLabel.RIGHT), gbc);
        
        textFieldID = new JTextField();
        textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.gridx = 1;
        contentPane.add(textFieldID, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(new JLabel("Mật khẩu:", JLabel.RIGHT), gbc);
        
        // Ô nhập Password
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.gridx = 1;
        contentPane.add(passwordField, gbc);

        // Checkbox để ẩn/hiện mật khẩu
        showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
        showPasswordCheckBox.setBackground(new Color(255, 255, 225));
        gbc.gridy = 4;
        gbc.gridx = 1;
        contentPane.add(showPasswordCheckBox, gbc);

        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0); 
            } else {
                passwordField.setEchoChar('•'); 
            }
        });

        // Nút Đăng nhập
        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Courier New", Font.BOLD, 15));
        btnLogin.setBackground(new Color(30, 144, 255));
        btnLogin.setForeground(Color.YELLOW);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        contentPane.add(btnLogin, gbc);

        // Nút Đăng ký
        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setFont(new Font("Courier New", Font.BOLD, 12));
        btnRegister.setBackground(new Color(154, 205, 50));
        btnRegister.setForeground(Color.YELLOW);
        gbc.gridy = 6;
        contentPane.add(btnRegister, gbc);

        // Nút Quên mật khẩu
        JButton btnForgotPassword = new JButton("Quên mật khẩu?");
        btnForgotPassword.setForeground(Color.RED);
        btnForgotPassword.setBackground(Color.WHITE);
        gbc.gridy = 7;
        contentPane.add(btnForgotPassword, gbc);

        UserController userController = new UserController(this, null);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldID.getText();
                String password = new String(passwordField.getPassword());
                
                if(ScannerUtils.isEmpty(username, password)) {
                	ScannerUtils.showErrorMessage(LoginView.this, "Các trường không được để trống!");
                	return;
                }
                
                userController.login(username, password);
            }
        });
        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	userController.showRegister();
            }
        });
    }
    
    
}
