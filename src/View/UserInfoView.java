package View;

import javax.swing.*;

import Model.Role;
import Model.Status;

import java.awt.*;


public class UserInfoView extends JFrame {
    private JLabel  nameLabel, usernameLabel, yearOldLabel, emailLabel, phoneLabel, statusLabel, roleLabel;

    public UserInfoView(String fullname, String yearold, String email,
                        String phoneNumber, String status, Role role) {
        setTitle("Thông tin người dùng");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel nameTitle = new JLabel(fullname);
        nameTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));

        topPanel.add(Box.createHorizontalStrut(20));
        topPanel.add(nameTitle);

        JPanel centerPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));


        centerPanel.add(new JLabel("Tuổi:"));
        yearOldLabel = new JLabel(yearold);
        centerPanel.add(yearOldLabel);

        centerPanel.add(new JLabel("Email:"));
        emailLabel = new JLabel(email);
        centerPanel.add(emailLabel);

        centerPanel.add(new JLabel("Số điện thoại:"));
        phoneLabel = new JLabel(phoneNumber);
        centerPanel.add(phoneLabel);

        centerPanel.add(new JLabel("Trạng thái:"));
        statusLabel = new JLabel(status);
        centerPanel.add(statusLabel);

        centerPanel.add(new JLabel("Vai trò:"));
        roleLabel = new JLabel(role.toString());
        centerPanel.add(roleLabel);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
}
