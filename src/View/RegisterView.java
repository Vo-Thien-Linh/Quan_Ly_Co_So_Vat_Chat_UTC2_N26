package view;

//import controller.RegisterController;
import Model.Role;
import Service.UserService;
import Controller.RegisterController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame{
	private JTextField usernameField, emailField, phoneNumberField;
    private JPasswordField passwordField;
    private JSpinner yearoldSpinner;
    private JComboBox<Role> roleComboBox;
    private JButton registerButton;

//    private RegisterController controller;

    public RegisterView() {
//        controller = new RegisterController(this);

    	setTitle("User Registration");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(8, 2));
        
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        panel.add(usernameField);
        
        panel.add(new JLabel("Year of Birth:"));
        yearoldSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        panel.add(yearoldSpinner);
        
        panel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        panel.add(emailField);
        
        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField(20);
        panel.add(phoneNumberField);
        
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        panel.add(passwordField);
        
        panel.add(new JLabel("Role:"));
        roleComboBox = new JComboBox<>(Role.values());
        panel.add(roleComboBox);

        registerButton = new JButton("Register");
        
        panel.add(registerButton);

        add(panel);


        RegisterController controller = new RegisterController(this);
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String username = usernameField.getText();
            	int yearold = (int) yearoldSpinner.getValue();
            	String email = emailField.getText();
            	String phoneNumber = phoneNumberField.getText();
            	String password = new String(passwordField.getPassword());
            	Role role = (Role) roleComboBox.getSelectedItem();
            	
            	if (username.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()) {
                    showErrorMessage("Các trường không được để trống!");
                    return;
                }

                if (!isValidEmail(email)) {
                    showErrorMessage("Email không hợp lệ!");
                    return;
                }
                
                if(!isValidPhoneNumber(phoneNumber)) {
                	showErrorMessage("Số điện thoại không hợp lệ!");
                	return;
                }

                if (!isValidPassword(password)) {
                    showErrorMessage("Mật khẩu phải có ít nhất 8 ký tự, tối đa 15 ký tự, bao gồm chữ in hoa, chữ in thường, số và ký tự đặc biệt!");
                    return;
                }
            	
                controller.register(username, yearold, email, phoneNumber, password, role);
            }
        });

    }
    
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
        return password.matches(passwordPattern);
    }
    
    private boolean isValidPhoneNumber(String phoneNumber) {
        String phonePattern = "^(\\+84|0)[0-9]{9}$";
        return phoneNumber.matches(phonePattern);
    }
    
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Thàng công", JOptionPane.INFORMATION_MESSAGE);
    }
}
