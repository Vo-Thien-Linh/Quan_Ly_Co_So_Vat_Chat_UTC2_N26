package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UserController;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class PageManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageManager frame = new PageManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PageManager() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PageManager.class.getResource("/IMG/logo-utc.png")));
		setTitle("Quản lý cơ sở vật chất UTC2 - Quản lý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 685);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{51, 58, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Quản Lý");
		lblNewLabel.setForeground(new Color(255, 215, 0));
//		lblNewLabel.setIcon(new ImageIcon(PageManager.class.getResource("/IMG/imgManager.png")));
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 25));
		panel_2.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		panel_2.add(lblNewLabel_1, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(100, 149, 237));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Đại học Giao Thông Vận Tải Phân hiệu tại TP.  Hồ Chí Minh");
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setIcon(new ImageIcon(PageManager.class.getResource("/IMG/logo-utc (1).png")));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		Button button = new Button("Quản lý phòng học");
		button.setForeground(new Color(0, 0, 139));
		button.setBackground(new Color(255, 250, 205));
		button.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_4.add(button);
		
		Button button_1 = new Button("Quản lý thiết bị");
		button_1.setForeground(new Color(0, 0, 139));
		button_1.setBackground(new Color(255, 250, 205));
		button_1.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_4.add(button_1);
		
		Button button_2 = new Button("Quản lý người dùng");
		button_2.setForeground(new Color(0, 0, 139));
		button_2.setBackground(new Color(255, 250, 205));
		button_2.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_4.add(button_2);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		CardLayout cardLayout = new CardLayout();
		panel_5.setLayout(cardLayout);
		
		
		Panel_ManagerRoom panelManagerRoom = new Panel_ManagerRoom();
		Panel_ManagerDevice panelManagerDevice = new Panel_ManagerDevice();
		Panel_ManagerUser panelManagerUser = new Panel_ManagerUser();

		panel_5.add(panelManagerRoom, "room");
		panel_5.add(panelManagerDevice, "device");
		panel_5.add(panelManagerUser, "user");
		
		cardLayout.show(panel_5, "user");
		
		button.addActionListener(e -> cardLayout.show(panel_5, "room"));
		button_1.addActionListener(e -> cardLayout.show(panel_5, "device"));
		button_2.addActionListener(e -> cardLayout.show(panel_5, "user"));


		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(100, 149, 237));
		contentPane.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Đăng xuất");
		panel_8.add(btnNewButton, BorderLayout.WEST);
		
		LoginView loginView = new LoginView();
		UserController userController = new UserController(loginView , null);
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                UserController.logout(PageManager.this);
            }
        });
	}
}
