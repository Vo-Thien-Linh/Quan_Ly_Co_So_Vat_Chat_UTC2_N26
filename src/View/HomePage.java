package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.LogoutController;

public class HomePage extends JFrame {
	private JButton btnLogout;
	
    public HomePage() {
    	
        setTitle("Trang Chủ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Chào mừng bạn đến với Trang Chủ!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  
        btnLogout = new JButton("Đăng xuất");
        buttonPanel.add(btnLogout);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(panel);
        mainPanel.add(Box.createVerticalGlue());  
        mainPanel.add(buttonPanel); 
        
        add(mainPanel);
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                LogoutController.logout(HomePage.this);
            }
        });
    }
}
