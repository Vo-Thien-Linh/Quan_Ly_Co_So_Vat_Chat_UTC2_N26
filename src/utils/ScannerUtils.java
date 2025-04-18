package utils;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ScannerUtils {
	public static boolean isEmpty(Object... fields) {
	    for (Object field : fields) {
	        if (field == null) {
	            return true;
	        }

	        if (field instanceof String && ((String) field).trim().isEmpty()) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static void clearForm(JTextField... fields) {
		for (JTextField field : fields) {
            field.setText("");
        }
	}
	
	public static void showErrorMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
	
	public static void showSuccessMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Thàng công", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static int showConfirmMessage(Component parent, String message) {
		return JOptionPane.showConfirmDialog(parent, message, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
    }
	
	public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
	
	public static boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&#]{8,15}$";
        return password != null && password.matches(passwordPattern);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phonePattern = "^(\\+84|0)[0-9]{9}$";
        return phoneNumber != null && phoneNumber.matches(phonePattern);
    }

    public static boolean isNumber(String input) {
        return input != null && input.matches("\\d+");
    }
}
