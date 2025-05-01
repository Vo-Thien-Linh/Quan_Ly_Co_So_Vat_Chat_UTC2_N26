package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UserController;
import View.RoundedComponents.RoundedButton;
import utils.PermissionUtils;
import Model.Manager;
import Model.Session;
import Model.User;
import Repository.UserRepository;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.RenderingHints;

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
    private LoginView loginView;
    private UserController controller = new UserController(loginView);
    private User inforUser;

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
		panel_3.setBackground(new Color(38, 30, 89));
		panel_3.setLayout(new GridBagLayout()); 

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		
		ImageIcon originalLogo = new ImageIcon(PageManager.class.getResource("/IMG/logo-utc (1).png"));
		Image scaledLogo = originalLogo.getImage().getScaledInstance(110, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledLogoIcon = new ImageIcon(scaledLogo);

		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(scaledLogoIcon);

		GridBagConstraints gbc_logoLabel = new GridBagConstraints();
		gbc_logoLabel.gridx = 0; 
		gbc_logoLabel.gridy = 0;
		gbc_logoLabel.insets = new Insets(0, 80, 0, 0);
		gbc_logoLabel.anchor = GridBagConstraints.WEST;
		panel_3.add(logoLabel, gbc_logoLabel);

		JLabel lblNewLabel_2 = new JLabel("Phần Mềm Quản Lý Cơ Sở Vật Chất UTC2");
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		gbc_lblNewLabel_2.weightx = 1.0;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.CENTER; 
		gbc_lblNewLabel_2.insets = new Insets(20, 10, 20, 0); 
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		getInforUser();
		URL avatarUrl = null;
		try {
			avatarUrl = new URL(inforUser.getThumbnail());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        ImageIcon imageAvatar = new ImageIcon(avatarUrl);
        Image avatar = imageAvatar.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        imageAvatar = new ImageIcon(avatar);
        BufferedImage bufferedImage = new BufferedImage(50, 40, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setClip(new RoundRectangle2D.Float(0, 0, 50, 40, 10, 10));  
        g2d.drawImage(avatar, 0, 0, null);
        g2d.dispose();

        ImageIcon roundedIcon = new ImageIcon(bufferedImage);
        JLabel avatarLabel = new JLabel(roundedIcon);

		// Tên người dùng
		RoundedButton buttonName = new RoundedButton(inforUser.getFullname(), 10);
		buttonName.setHorizontalTextPosition(JButton.RIGHT); 
		buttonName.setVerticalTextPosition(JButton.CENTER);
		buttonName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonName.setForeground(Color.BLACK);
		buttonName.setBackground(new Color(19, 193, 244));
		buttonName.setFont(new Font("Arial", Font.BOLD, 16));
		buttonName.setPreferredSize(new Dimension(240, 40));
		buttonName.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	buttonName.setBackground(new Color(12, 128, 162)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	buttonName.setBackground(new Color(19, 193, 244));
		    }
		});
		
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
		userPanel.setBackground(new Color(38, 30, 89));
		userPanel.add(avatarLabel);
		userPanel.add(buttonName);

		GridBagConstraints gbc_userPanel = new GridBagConstraints();
		gbc_userPanel.gridx = 1; 
		gbc_userPanel.gridy = 0;
		gbc_userPanel.insets = new Insets(10, 0, 10, 10); 
		panel_3.add(userPanel, gbc_userPanel);
		
		RoundedButton btnNewButton = new RoundedButton("Đăng xuất", 10);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/IMG/logout (2).png")));
		btnNewButton.setHorizontalTextPosition(JButton.RIGHT); 
		btnNewButton.setVerticalTextPosition(JButton.CENTER);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(new Color(200, 35, 51));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setPreferredSize(new Dimension(170, 40));
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(new Color(133, 23, 34)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(new Color(200, 35, 51));
		    }
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 10);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0; 
		panel_3.add(btnNewButton, gbc_btnNewButton);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(25, 25, 112));
        menuPanel.setPreferredSize(new Dimension(280, 0));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));


        String[] menuItems = {"Quản lý phòng", "Quản lý thiết bị", "Quản lý người dùng", "Phân quyền", "Mượn phòng", "Mượn thiết bị"};
        
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

		Panel_ManagerRoom panelManagerRoom = new Panel_ManagerRoom();
		Panel_ManagerDevice panelManagerDevice = new Panel_ManagerDevice();
		Panel_ManagerUser panelManagerUser = new Panel_ManagerUser();
		PermissionView permissionView = new PermissionView();
		Panel_RentDevice panelRentDevice = new Panel_RentDevice();
		Panel_RentRoom panelRentRoom = new Panel_RentRoom();
		
        for (String item : menuItems) {
        	Boolean[] rights = PermissionUtils.getRights(item);
        	if (!rights[0]) {
                continue; 
            }
        	
        	if(item == "Quản lý phòng") {
        		contentPanel.add(panelManagerRoom, item);
        	} else if (item == "Quản lý thiết bị") {
        		contentPanel.add(panelManagerDevice, item);
        	} else if(item == "Quản lý người dùng"){
        		contentPanel.add(panelManagerUser, item);
        	} else if(item == "Phân quyền"){
        		contentPanel.add(permissionView, item);
        	} else if(item == "Mượn phòng") {
        		contentPanel.add(panelRentRoom, item);
        	} else {
        		contentPanel.add(panelRentDevice, item);
        	}
        }
        
        boolean isFirst = true;
        
        String[] iconPaths = {"/IMG/room.png", "/IMG/settings.png", "/IMG/profile.png", "/IMG/key.png", "/IMG/key (1).png", "/IMG/mobile.png"};
        for (int i = 0; i < menuItems.length; i++) {
            String item = menuItems[i];
            Boolean[] rights = PermissionUtils.getRights(item);
        	if (!rights[0]) {
                continue; 
            }
            String iconPath = iconPaths[i];

            ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
            Image image = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);

            JButton btn = new JButton(item, icon);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(280, 60));
            btn.setBackground(new Color(25, 25, 112));
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
                        btn.setBackground(new Color(25, 25, 112));  
                    }
                }
            });
            
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(contentPanel, item);
                    
                    if (selectedButton != null) {
                        selectedButton.setBackground(new Color(25, 25, 112));
                    }

                    selectedButton = btn;
                    btn.setBackground(new Color(70, 70, 120));
                }
            });

            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            menuPanel.add(btn);
        }
        
        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(100, 149, 237));
		contentPane.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		LoginView loginView = new LoginView();
		UserController userController = new UserController(loginView);
		
		//Bắt sự kiện nút đăng xuất
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	Session.clear();
                UserController.logout(PageManager.this);
            }
        });
		
		
		
		buttonName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User inforUser = controller.getInforUser(Session.getUserId());
				buttonName.setText(inforUser.getFullname());
			}
		});
	}
	
	private void getInforUser() {
		inforUser = controller.getInforUser(Session.getUserId());
	}
}
