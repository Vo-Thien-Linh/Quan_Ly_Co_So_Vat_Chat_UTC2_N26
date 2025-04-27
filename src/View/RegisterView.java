package View;


import Model.Role;
import utils.PasswordEncryptionUtils;
import utils.ScannerUtils;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.Choice;
import java.awt.AlphaComposite;
import java.awt.Button;

public class RegisterView extends JFrame{
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTextField textField;
//	private JTextField text;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JPasswordField passwordField;
	private JPanel contentPanel;
    private JTextField fullNameField, usernameField, dobField, emailField, phoneField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton btnRegister, btnBack;
    private JCheckBox showPasswordCheckBox;


    public RegisterView() {
    	
    	setTitle("Quản lý cơ sở vật chất UTC2 - Đăng ký");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/logo-utc.png")));
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
        setBounds(100, 100, 700, 750);
        setLocationRelativeTo(null);

        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(245,245,245));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        JLabel lblTitle = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
        lblTitle.setForeground(new Color(0, 128, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("DialogInput", Font.BOLD, 28));
        lblTitle.setBounds(170, 50, 350, 50);
        contentPanel.add(lblTitle);

        fullNameField = createTextField("Họ và tên", 100);
        usernameField = createTextField("Tên đăng nhập", 170);
        dobField = createTextField("Ngày sinh (dd/MM/yyyy)", 240);
        emailField = createTextField("Email", 310);
        phoneField = createTextField("Số điện thoại", 380);

        JLabel lblPassword = new JLabel("Mật khẩu");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(175, 450, 300, 30);
        contentPanel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordField.setBackground(new Color(235, 235, 235));
        passwordField.setBounds(175, 480, 340, 40);
        contentPanel.add(passwordField);
        
        showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
		showPasswordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPassword();
			}
		});
		showPasswordCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		showPasswordCheckBox.setBounds(380, 525, 138, 25);
		contentPanel.add(showPasswordCheckBox);

		
        JLabel lblRole = new JLabel("Chức vụ");
        lblRole.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblRole.setBounds(175, 540, 300, 30);
        contentPanel.add(lblRole);
        
        roleComboBox = new JComboBox<>();
        for (Role role : Role.values()) {
			if(role.name() == "MAINTENANCE") {
				roleComboBox.addItem("BẢO TRÌ");
			} else {
				roleComboBox.addItem("GIÁO VIÊN");
			}
		}
        roleComboBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        roleComboBox.setBounds(175, 570, 340, 40);
        contentPanel.add(roleComboBox);
		
		btnRegister = new JButton("Đăng ký");
        btnRegister.setBackground(new Color(30, 30, 150));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Dialog", Font.BOLD, 20));
        btnRegister.setBounds(195, 630, 140, 50);
        btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnRegister.setBackground(new Color(25, 25, 112)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnRegister.setBackground(new Color(30, 30, 150));
		    }
		});
        contentPanel.add(btnRegister);

        btnBack = new JButton("Trở về");
        btnBack.setBackground(new Color(70, 130, 180));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
        btnBack.setBounds(355, 630, 140, 50);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	btnBack.setBackground(new Color(50, 90, 150)); 
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnBack.setBackground(new Color(70, 130, 180)); 
            }
        });
        contentPanel.add(btnBack);
        
        JButton btn_backgound2 = new JButton("");
		btn_backgound2.setEnabled(false);
		btn_backgound2.setFont(new Font("Dialog", Font.BOLD, 25));
		btn_backgound2.setBackground(new Color(240, 240, 240));
		btn_backgound2.setBounds(115, 50, 460, 640);
		contentPanel.add(btn_backgound2);
		
		ImageIcon icon = new ImageIcon(LoginView.class.getResource("/IMG/logo-utc.png"));

		int width = icon.getIconWidth();
		int height = icon.getIconHeight();

		BufferedImage buffered = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = buffered.createGraphics();
		g2d.drawImage(icon.getImage(), 0, 0, null);
		g2d.dispose();

		BufferedImage finalImage = new BufferedImage(1150, 850, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d2 = finalImage.createGraphics();

		g2d2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g2d2.drawImage(buffered, 0, 0, 1150, 850, null);
		g2d2.dispose();

		ImageIcon newIcon = new ImageIcon(finalImage);

		JLabel lbl_backgrond = new JLabel("");
		lbl_backgrond.setIcon(newIcon);
		lbl_backgrond.setBounds(-230, -50, 1000, 800); 
		contentPanel.add(lbl_backgrond);


        UserController userController = new UserController(null, this);
        
//        Bắt sự kiện click nút đăng ký
//        btnRegister.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	String fullname = fullNameField.getText();
//            	String username = usernameField.getText();
//                String yearold = dobField.getText();
//                String email = emailField.getText();
//                String phoneNumber = phoneField.getText();
//                String password = new String(passwordField.getPassword());
//                String roleString = (String) roleComboBox.getSelectedItem(); 
//                		
//                Role role = Role.LECTURER; 
//		        if (roleString.equals("BẢO TRÌ")) {
//		            role = Role.MAINTENANCE;	
//		        }
//            	
//            	if (ScannerUtils.isEmpty(fullname, username, yearold, email, phoneNumber, password)) {
//                    ScannerUtils.showErrorMessage(RegisterView.this, "Các trường không được để trống!");
//                    return;
//                }
//            	
//            	ScannerUtils.handleDateValidation(yearold, RegisterView.this);
//
//                if (!ScannerUtils.isValidEmail(email)) {
//                    ScannerUtils.showErrorMessage(RegisterView.this, "Email không hợp lệ!");
//                    return;
//                }
//                
//                if(!ScannerUtils.isValidPhoneNumber(phoneNumber)) {
//                	ScannerUtils.showErrorMessage(RegisterView.this, "Số điện thoại không hợp lệ!");
//                	return;
//                }
//
//                if (!ScannerUtils.isValidPassword(password)) {
//                    ScannerUtils.showErrorMessage(RegisterView.this, "Mật khẩu phải có ít nhất 8 ký tự, tối đa 15 ký tự, bao gồm chữ in hoa, chữ in thường, số và ký tự đặc biệt!");
//                    return;
//                }
//            	
//                userController.register(fullname, username, thumbnail, yearold, email, phoneNumber, PasswordEncryptionUtils.hashPassword(password), role);
//            }
//        });
        
//        Bắt sự kiện nút trở về
        btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginView().setVisible(true);
			}
		});
    }
    
    private JTextField createTextField(String placeholder, int y) {
        JLabel label = new JLabel(placeholder);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(175, y, 300, 30);
        contentPanel.add(label);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 18));
        textField.setBackground(new Color(235, 235, 235));
        textField.setBounds(175, y + 30, 340, 40);
        contentPanel.add(textField);

        return textField;
    }

    private void displayPassword() {
	    if (showPasswordCheckBox.isSelected()) {
	        passwordField.setEchoChar((char) 0);
	    } else {
	        passwordField.setEchoChar('\u2022');
	    }
	}
}
