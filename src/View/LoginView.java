package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.UserController;
import Service.UserService;
import utils.ScannerUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JCheckBox showPasswordCheckBox;

    public LoginView() {
    	setTitle("Đăng nhập hệ thống quản lí cơ sở vật chất UTC2");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/IMG/logo-utc.png")));
		
		setBounds(100, 100, 609, 639);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245,245,245));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
		showPasswordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPassword();
			}
		});
			
		JLabel lbl_titleDangNhapHeThong = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
		lbl_titleDangNhapHeThong.setForeground(new Color(0, 128, 255));
		lbl_titleDangNhapHeThong.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titleDangNhapHeThong.setFont(new Font("DialogInput", Font.BOLD, 28));
		lbl_titleDangNhapHeThong.setBounds(130, 90, 330, 79);
		contentPanel.add(lbl_titleDangNhapHeThong);
		showPasswordCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		showPasswordCheckBox.setBounds(322, 324, 138, 25);
		contentPanel.add(showPasswordCheckBox);
		
		JLabel lbl_tenDangNhap = new JLabel("Tên đăng nhập");
		lbl_tenDangNhap.setIcon(new ImageIcon(LoginView.class.getResource("/IMG/Apps-preferences-desktop-user-password-icon-24.png")));
		lbl_tenDangNhap.setBackground(new Color(128, 128, 255));
		lbl_tenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_tenDangNhap.setBounds(135, 145, 295, 50);
		contentPanel.add(lbl_tenDangNhap);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Dialog", Font.PLAIN, 18));
		usernameField.setBackground(new Color(235, 235, 235));
		usernameField.setBounds(134, 193, 325, 40);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblmatKhau = new JLabel("Mật khẩu");
		lblmatKhau.setBackground(Color.CYAN);
		lblmatKhau.setIcon(new ImageIcon(LoginView.class.getResource("/IMG/gpa-icon-24.png")));
		lblmatKhau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblmatKhau.setBounds(135, 235, 302, 50);
		contentPanel.add(lblmatKhau);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setBackground(new Color(235, 235, 235));
		passwordField.setBounds(135, 276, 325, 40);
		contentPanel.add(passwordField);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setBackground(new Color(30, 30, 150));
		btnLogin.setForeground(Color.WHITE); 
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 25));
		btnLogin.setBounds(135, 357, 325, 73);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnLogin.setBackground(new Color(25, 25, 112)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnLogin.setBackground(new Color(30, 30, 150));
		    }
		});

		contentPanel.add(btnLogin);
        
        JButton btnForgotPassword = new JButton("Quên mật khẩu");
        btnForgotPassword.setBackground(new Color(70, 130, 180)); 
        btnForgotPassword.setForeground(Color.WHITE);
        btnForgotPassword.setFont(new Font("Dialog", Font.BOLD, 18));
        btnForgotPassword.setBounds(135, 445, 325, 73);
        btnForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	btnForgotPassword.setBackground(new Color(50, 90, 150)); 
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnForgotPassword.setBackground(new Color(70, 130, 180));
            }
        });
        contentPanel.add(btnForgotPassword);
		
		JButton btn_backgound2 = new JButton("");
		btn_backgound2.setEnabled(false);
		btn_backgound2.setFont(new Font("Dialog", Font.BOLD, 25));
		btn_backgound2.setBackground(new Color(240, 240, 240));
		btn_backgound2.setBounds(115, 90, 360, 450);
		contentPanel.add(btn_backgound2);
		
		ImageIcon icon = new ImageIcon(LoginView.class.getResource("/IMG/logo-utc.png"));

		int width = icon.getIconWidth();
		int height = icon.getIconHeight();

		BufferedImage buffered = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = buffered.createGraphics();
		g2d.drawImage(icon.getImage(), 0, 0, null);
		g2d.dispose();

		BufferedImage finalImage = new BufferedImage(950, 750, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d2 = finalImage.createGraphics();

		g2d2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g2d2.drawImage(buffered, 0, 0, 950, 750, null);
		g2d2.dispose();

		ImageIcon newIcon = new ImageIcon(finalImage);

		JLabel lbl_backgrond = new JLabel("");
		lbl_backgrond.setIcon(newIcon);
		lbl_backgrond.setBounds(-180, 0, 800, 600); 
		contentPanel.add(lbl_backgrond);	
		setLocationRelativeTo(null);

        UserController userController = new UserController(this);
//        bắt sự kiện nút đăng nhập
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if(ScannerUtils.isEmpty(username, password)) {
                	ScannerUtils.showErrorMessage(LoginView.this, "Các trường không được để trống!");
                	return;
                }
                
                userController.login(username, password);
            }
        });
        
//        bắt sự kiện nút quên mật khẩu
        btnForgotPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ForgotPasswordView().setVisible(true);
			}
		});
    }
    
    private void displayPassword() {
	    if (showPasswordCheckBox.isSelected()) {
	        passwordField.setEchoChar((char) 0);
	    } else {
	        passwordField.setEchoChar('\u2022');
	    }
	}
}
