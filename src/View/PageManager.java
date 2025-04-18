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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PageManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
    private JPanel contentPanel;
    private JButton selectedButton = null;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(25, 25, 112));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Phần Mềm Quản Lý Cơ Sở Vật Chất UTC2");
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		panel_3.add(lblNewLabel_2);
		
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(30, 30, 80) );
        menuPanel.setPreferredSize(new Dimension(280, 0));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        
        ImageIcon originalLogo = new ImageIcon(PageManager.class.getResource("/IMG/logo-utc (1).png"));
        Image scaledLogo = originalLogo.getImage().getScaledInstance(95, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogo);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(scaledLogoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel textLabel = new JLabel("UTC2");
        textLabel.setForeground(new Color(255, 215, 0)); 
        textLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        menuPanel.add(logoLabel);
        menuPanel.add(textLabel);


        String[] menuItems = {"Quản lý phòng", "Quản lý thiết bị", "Quản lý người dùng",};
        
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

		Panel_ManagerRoom panelManagerRoom = new Panel_ManagerRoom();
		Panel_ManagerDevice panelManagerDevice = new Panel_ManagerDevice();
		Panel_ManagerUser panelManagerUser = new Panel_ManagerUser();
		
        for (String item : menuItems) {
        	if(item == "Quản lý phòng") {
        		contentPanel.add(panelManagerRoom, item);
        	} else if (item == "Quản lý thiết bị") {
        		contentPanel.add(panelManagerDevice, item);
        	} else {
        		contentPanel.add(panelManagerUser, item);
        	}
        }
        
        boolean isFirst = true;
        
        String[] iconPaths = {"/IMG/room.png", "/IMG/settings.png", "/IMG/profile.png"};
        for (int i = 0; i < menuItems.length; i++) {
            String item = menuItems[i];
            String iconPath = iconPaths[i];

            ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
            Image image = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);

            JButton btn = new JButton(item, icon);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(280, 60));
            btn.setBackground(new Color(30, 30, 80));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            
            if (isFirst) {
                btn.setBackground(new Color(70, 70, 120));
                selectedButton = btn;
                cardLayout.show(contentPanel, item); 
                isFirst = false;
            }

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(70, 70, 120));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if (selectedButton != btn) {
                        btn.setBackground(new Color(30, 30, 80));  
                    }
                }
            });
            
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(contentPanel, item);
                    
                    if (selectedButton != null) {
                        selectedButton.setBackground(new Color(30, 30, 80));
                    }

                    selectedButton = btn;
                    btn.setBackground(new Color(70, 70, 120));
                }
            });

            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            menuPanel.add(btn);
        }
        
        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(100, 149, 237));
		contentPane.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
//		JButton btnNewButton = new JButton("Đăng xuất");
//		panel_8.add(btnNewButton, BorderLayout.WEST);
		
		LoginView loginView = new LoginView();
		UserController userController = new UserController(loginView , null);
//		btnNewButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                UserController.logout(PageManager.this);
//            }
//        });
	}
}
