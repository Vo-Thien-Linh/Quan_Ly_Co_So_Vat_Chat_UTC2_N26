package utils;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static boolean isValidDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); 
            Date date = dateFormat.parse(dateStr); 

            return true;

        } catch (ParseException e) {
            return false;
        }
    }

    public static void handleDateValidation(String dateStr, JPanel panel) {
        if (!isValidDate(dateStr)) {
            JOptionPane.showMessageDialog(panel, "Ngày tháng năm sinh không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Ngày sinh hợp lệ: " + dateStr);
        }
    }
}
