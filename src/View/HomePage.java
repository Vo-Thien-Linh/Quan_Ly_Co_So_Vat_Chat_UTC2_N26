package View;

import javax.swing.*;

public class HomePage extends JFrame {
    public HomePage() {
        setTitle("Trang Chủ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Chào mừng bạn đến với Trang Chủ!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(label);
    }
}
