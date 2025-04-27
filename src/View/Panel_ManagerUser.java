package View;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Controller.ManagerUserController;
import Controller.UserController;
import Model.Admin;
import Model.Manager;
import Model.Role;
import Model.Status;
import Model.User;
import View.RoundedComponents.RoundedButton;
import View.RoundedComponents.RoundedTextField;
import utils.ScannerUtils;
import utils.CloudinaryUploaderUtils;
import utils.PasswordEncryptionUtils;
import utils.PasswordGeneratorUtils;
import utils.ScannerUtils;

import java.awt.BorderLayout;
import java.awt.Button;

public class Panel_ManagerUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JFrame uploadImg;
	private RoundedTextField search;
	private RoundedTextField textField;
	private RoundedTextField textField_1;
	private RoundedTextField textField_2;
	private RoundedTextField textField_3;
	private RoundedTextField textField_4;
	private RoundedTextField textField_5;
	private ManagerUserController controller;

	/**
	 * Create the panel.
	 */
	
	public Panel_ManagerUser() {
		setBackground(new Color(255, 250, 205));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{878, 0};
		gbl_panel.rowHeights = new int[]{535, 13, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(238, 238, 238));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{279, 276, 0, 197, 394};
		gbl_panel_2.rowHeights = new int[]{71, 55, 55, 53, 55, 50, 112, 0, 7, 50};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 4.9E-324};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		search = new RoundedTextField(10, 50);
        search.setPlaceholder("Nhập mã/Tên");
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        search.setColumns(10);
        GridBagConstraints gbc_search = new GridBagConstraints();
        gbc_search.anchor = GridBagConstraints.NORTHEAST;
        gbc_search.insets = new Insets(10, 0, 5, 5);
        gbc_search.gridx = 0;
        gbc_search.gridy = 0;
        gbc_search.weightx = 1.0;
        panel_2.add(search, gbc_search);   
        
        RoundedButton search_1 = new RoundedButton("", 10);
        search_1.setIcon(new ImageIcon(getClass().getResource("/IMG/search.png")));
        search_1.setHorizontalTextPosition(JButton.RIGHT); 
        search_1.setVerticalTextPosition(JButton.CENTER);
        search_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search_1.setForeground(new Color(4, 42, 54));
        search_1.setBackground(new Color(149, 227, 249));
        search_1.setFont(new Font("Arial", Font.BOLD, 16));
        search_1.setPreferredSize(new Dimension(50, 35));
        search_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	search_1.setBackground(new Color(19, 193, 244)); 
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	search_1.setBackground(new Color(149, 227, 249));
            }
        });
        GridBagConstraints gbc_search_1 = new GridBagConstraints();
        gbc_search_1.anchor = GridBagConstraints.NORTHWEST;
        gbc_search_1.insets = new Insets(10, 5, 5, 5);
        gbc_search_1.gridx = 1;
        gbc_search_1.gridy = 0; 
        panel_2.add(search_1, gbc_search_1);
		
		JLabel lblHVTn = new JLabel("Họ và tên: ");
		lblHVTn.setFont(new Font("Arial", Font.BOLD, 20));
		lblHVTn.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblHVTn = new GridBagConstraints();
		gbc_lblHVTn.anchor = GridBagConstraints.WEST;
		gbc_lblHVTn.insets = new Insets(0, 50, 5, 5);
		gbc_lblHVTn.gridx = 0;
		gbc_lblHVTn.gridy = 1;
		panel_2.add(lblHVTn, gbc_lblHVTn);
		
		textField_1 = new RoundedTextField(10, 250);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_2.add(textField_1, gbc_textField_1);
		
		JLabel lblStatus = new JLabel("Trạng thái: ");
		lblStatus.setFont(new Font("Arial", Font.BOLD, 20));
		lblStatus.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 2;
		gbc_lblStatus.gridy = 1;
		panel_2.add(lblStatus, gbc_lblStatus);
		
		JComboBox<String> comboBoxStatus = new JComboBox<>();
		comboBoxStatus.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxStatus.setPreferredSize(new Dimension(150, 30)); 

		for (Status status : Status.values()) {
		    if (status.name().equals("MAINTENANCE")) {
		        comboBoxStatus.addItem("ĐANG BẢO TRÌ");
		    } else if (status.name().equals("ACTIVE")) {
		        comboBoxStatus.addItem("HOẠT ĐỘNG");
		    } else {
		        comboBoxStatus.addItem("DỪNG HOẠT ĐỘNG");
		    }
		}

		// Set GridBagConstraints cho JComboBox
		GridBagConstraints gbc_comboBoxStatus = new GridBagConstraints();
		gbc_comboBoxStatus.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxStatus.anchor = GridBagConstraints.WEST;
		gbc_comboBoxStatus.gridx = 3;
		gbc_comboBoxStatus.gridy = 1;

		// Thêm ComboBox vào panel
		panel_2.add(comboBoxStatus, gbc_comboBoxStatus);

		
		
		JLabel lblPhi = new JLabel("Tên đăng nhập: ");
		lblPhi.setFont(new Font("Arial", Font.BOLD, 20));
		lblPhi.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblPhi = new GridBagConstraints();
		gbc_lblPhi.anchor = GridBagConstraints.WEST;
		gbc_lblPhi.insets = new Insets(0, 50, 5, 5);
		gbc_lblPhi.gridx = 0;
		gbc_lblPhi.gridy = 2;
		panel_2.add(lblPhi, gbc_lblPhi);
		
		textField_2 = new RoundedTextField(10, 250);
		textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_2.add(textField_2, gbc_textField_2);
		
		JLabel lblVaiTr = new JLabel("Vai trò: ");
		lblVaiTr.setFont(new Font("Arial", Font.BOLD, 20));
		lblVaiTr.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblVaiTr = new GridBagConstraints();
		gbc_lblVaiTr.anchor = GridBagConstraints.WEST;
		gbc_lblVaiTr.insets = new Insets(0, 0, 5, 5);
		gbc_lblVaiTr.gridx = 2;
		gbc_lblVaiTr.gridy = 2;
		panel_2.add(lblVaiTr, gbc_lblVaiTr);
		
		JComboBox<String> comboBoxRole = new JComboBox<>();
		comboBoxRole.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxRole.setPreferredSize(new Dimension(150, 30));
		GridBagConstraints gbc_choice_2 = new GridBagConstraints();
		gbc_choice_2.insets = new Insets(0, 0, 5, 5);
		gbc_choice_2.anchor = GridBagConstraints.WEST;
		gbc_choice_2.gridx = 3;
		gbc_choice_2.gridy = 2;
		panel_2.add(comboBoxRole, gbc_choice_2);
		for (Role role : Role.values()) {
			if(role.name() == "MAINTENANCE") {
				comboBoxRole.addItem("BẢO TRÌ");
			} else {
				comboBoxRole.addItem("GIÁO VIÊN");
			}
		}
		
		JLabel lblNgySinh = new JLabel("Ngày tháng năm sinh: ");
		lblNgySinh.setFont(new Font("Arial", Font.BOLD, 20));
		lblNgySinh.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblNgySinh = new GridBagConstraints();
		gbc_lblNgySinh.anchor = GridBagConstraints.WEST;
		gbc_lblNgySinh.insets = new Insets(0, 50, 5, 5);
		gbc_lblNgySinh.gridx = 0;
		gbc_lblNgySinh.gridy = 3;
		panel_2.add(lblNgySinh, gbc_lblNgySinh);
		
		textField_3 = new RoundedTextField(10, 250);
		textField_3.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_2.add(textField_3, gbc_textField_3);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại: ");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 20));
		lblSinThoi.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblSinThoi = new GridBagConstraints();
		gbc_lblSinThoi.anchor = GridBagConstraints.WEST;
		gbc_lblSinThoi.insets = new Insets(0, 50, 5, 5);
		gbc_lblSinThoi.gridx = 0;
		gbc_lblSinThoi.gridy = 4;
		panel_2.add(lblSinThoi, gbc_lblSinThoi);
		
		textField_4 = new RoundedTextField(10, 250);
		textField_4.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panel_2.add(textField_4, gbc_textField_4);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 50, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		panel_2.add(lblEmail, gbc_lblEmail);
		
		textField_5 = new RoundedTextField(10, 250);
		textField_5.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		panel_2.add(textField_5, gbc_textField_5);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setPreferredSize(new Dimension(150, 100));
		imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_imageLabel.anchor = GridBagConstraints.WEST;
		gbc_imageLabel.gridx = 1;
		gbc_imageLabel.gridy = 6;
		panel_2.add(imageLabel, gbc_imageLabel); 
		JButton uploadButton = new JButton("Chọn ảnh");
		uploadButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int option = fileChooser.showOpenDialog(null);
		        if(option == JFileChooser.APPROVE_OPTION){
		            File file = fileChooser.getSelectedFile();
		            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
		            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		            imageLabel.setIcon(new ImageIcon(image));
		        }
		    }
		});
		GridBagConstraints gbc_uploadButton = new GridBagConstraints();
		gbc_uploadButton.anchor = GridBagConstraints.EAST;
		gbc_uploadButton.insets = new Insets(0, 0, 5, 5);
		gbc_uploadButton.gridx = 0;
		gbc_uploadButton.gridy = 6;
		panel_2.add(uploadButton, gbc_uploadButton); 

		JPanel listPanel = new JPanel(new BorderLayout());
        String[] columns = {
        		"Mã người dùng", "Hình ảnh", "Họ và tên", "Tên đăng nhập", "Ngày tháng năm sinh","Số điện thoại", "Email", "Trạng thái", "Vai trò"
        };

        DefaultTableModel model = new DefaultTableModel(null, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Class<?> getColumnClass(int column) {
                if (column == 1) return ImageIcon.class;
                return String.class;
            }
        };
        
        table = new JTable(model);
        table.setRowHeight(50);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setIntercellSpacing(new Dimension(0, 0)); 
        table.setFocusable(false); 
        table.setForeground(new Color(6, 46, 75)); 

        DefaultTableCellRenderer noFocusRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, false, row, column);

                if (c instanceof JComponent) {
                    ((JComponent) c).setBorder(null); 
                }


                if (isSelected) {
                    c.setBackground(new Color(200, 230, 255)); 
                } else {
                    c.setBackground(Color.WHITE); 
                }

                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(noFocusRenderer);
        }


        JTableHeader header = table.getTableHeader();
        table.getTableHeader().setPreferredSize(new Dimension(0, 40));
        header.setBackground(new Color(0, 98, 102));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                lbl.setBackground(new Color(10, 70, 113));
                lbl.setForeground(Color.WHITE);
                lbl.setFont(new Font("Arial", Font.BOLD, 14));
                lbl.setHorizontalAlignment(CENTER);
                lbl.setBorder(BorderFactory.createEmptyBorder());

                return lbl;
            }
        });
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);

//        listPanel.setBounds(30, 110, 0, 500); 
        listPanel.add(scrollPane, BorderLayout.CENTER);
        
        GridBagConstraints gbc_listPanel = new GridBagConstraints();
        gbc_listPanel.insets = new Insets(0, 5, 5, 5);
        gbc_listPanel.fill = GridBagConstraints.BOTH;
        gbc_listPanel.gridx = 0;
        gbc_listPanel.gridy = 1; 
        panel.add(listPanel, gbc_listPanel);
        
        RoundedButton button = new RoundedButton("Thêm", 10);
		button.setIcon(new ImageIcon(getClass().getResource("/IMG/add.png")));
		button.setHorizontalTextPosition(JButton.RIGHT); 
		button.setVerticalTextPosition(JButton.CENTER);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setForeground(new Color(4, 42, 54));
		button.setBackground(new Color(149, 227, 249));
		button.setFont(new Font("Arial", Font.BOLD, 20));
		button.setPreferredSize(new Dimension(150, 40));
		button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button.setBackground(new Color(19, 193, 244)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button.setBackground(new Color(149, 227, 249));
		    }
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(5, 5, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 1; 
		panel_2.add(button, gbc_button);
        
        RoundedButton button_1 = new RoundedButton("Sửa", 10);
        button_1.setIcon(new ImageIcon(getClass().getResource("/IMG/pen (1).png")));
        button_1.setHorizontalTextPosition(JButton.RIGHT); 
        button_1.setVerticalTextPosition(JButton.CENTER);
        button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_1.setForeground(new Color(4, 42, 54));
        button_1.setBackground(new Color(149, 227, 249));
        button_1.setFont(new Font("Arial", Font.BOLD, 20));
        button_1.setPreferredSize(new Dimension(150, 40));
        button_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	button_1.setBackground(new Color(19, 193, 244)); 
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	button_1.setBackground(new Color(149, 227, 249));
            }
        });
        GridBagConstraints gbc_button_1 = new GridBagConstraints();
        gbc_button_1.insets = new Insets(5, 5, 5, 0);
        gbc_button_1.gridx = 4;
        gbc_button_1.gridy = 2; 
        panel_2.add(button_1, gbc_button_1);
        button_1.setEnabled(false);
        
        RoundedButton button_2 = new RoundedButton("Xóa", 10);
		button_2.setIcon(new ImageIcon(getClass().getResource("/IMG/trash (1).png")));
		button_2.setHorizontalTextPosition(JButton.RIGHT); 
		button_2.setVerticalTextPosition(JButton.CENTER);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setForeground(new Color(4, 42, 54));
		button_2.setBackground(new Color(149, 227, 249));
		button_2.setFont(new Font("Arial", Font.BOLD, 20));
		button_2.setPreferredSize(new Dimension(150, 40));
		button_2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button_2.setBackground(new Color(19, 193, 244)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button_2.setBackground(new Color(149, 227, 249));
		    }
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(5, 5, 5, 0);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 3; 
		panel_2.add(button_2, gbc_button_2);
    	button_2.setEnabled(false);
    	
    	RoundedButton button_3 = new RoundedButton("Hủy bỏ", 10);
    	button_3.setIcon(new ImageIcon(getClass().getResource("/IMG/close.png")));
    	button_3.setHorizontalTextPosition(JButton.RIGHT); 
    	button_3.setVerticalTextPosition(JButton.CENTER);
    	button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	button_3.setForeground(new Color(4, 42, 54));
    	button_3.setBackground(new Color(149, 227, 249));
    	button_3.setFont(new Font("Arial", Font.BOLD, 20));
    	button_3.setPreferredSize(new Dimension(150, 40));
    	button_3.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button_3.setBackground(new Color(19, 193, 244)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button_3.setBackground(new Color(149, 227, 249));
		    }
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(5, 5, 5, 0);
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 4; 
		panel_2.add(button_3, gbc_button_3);
		button_3.setEnabled(false);
		
		RoundedButton button_4 = new RoundedButton("Lưu", 10);
		button_4.setIcon(new ImageIcon(getClass().getResource("/IMG/bookmark.png")));
		button_4.setHorizontalTextPosition(JButton.RIGHT); 
		button_4.setVerticalTextPosition(JButton.CENTER);
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setForeground(new Color(4, 42, 54));
		button_4.setBackground(new Color(149, 227, 249));
		button_4.setFont(new Font("Arial", Font.BOLD, 20));
		button_4.setPreferredSize(new Dimension(150, 40));
		button_4.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button_4.setBackground(new Color(19, 193, 244)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button_4.setBackground(new Color(149, 227, 249));
		    }
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(5, 5, 5, 0);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 5; 
		panel_2.add(button_4, gbc_button_4);
		button_4.setEnabled(false);
		controller = new ManagerUserController(null, null);
		loadUserData();
		
		
//		Bắt sự kiện nút thêm
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String fullname = textField_1.getText();
		        String username = textField_2.getText();
		        String yearold = textField_3.getText();
		        String phoneNumber = textField_4.getText();
		        new PasswordGeneratorUtils();
				String password = PasswordEncryptionUtils.hashPassword(PasswordGeneratorUtils.generateStrongPassword());
		        String email = textField_5.getText(); 
		        String statusString = (String) comboBoxStatus.getSelectedItem();
		        String roleString = (String) comboBoxRole.getSelectedItem();
		        
		        Status status = Status.ACTIVE;
		        if(statusString.equals("DỪNG HOẠT ĐỘNG")) {
		        	status = Status.INACTIVE;
		        } else if(statusString.equals("BẢO TRÌ")) {
		        	status = Status.MAINTENANCE;
		        }
		        
		        Role role = Role.LECTURER; 
		        if (roleString.equals("BẢO TRÌ")) {
		            role = Role.MAINTENANCE;	
		        }
		        
		        if (ScannerUtils.isEmpty(fullname, username, yearold, phoneNumber, email)) {
		        	ScannerUtils.showErrorMessage(Panel_ManagerUser.this, "Vui lòng điền đầy đủ thông tin!");
		            return;
		        }
		        
		        String thumbnail = null;
		        
		        if (imageLabel.getIcon() != null) {
		            ImageIcon imageIcon = (ImageIcon) imageLabel.getIcon();
		            Image image = imageIcon.getImage();
		            
		            // Chuyển ảnh thành BufferedImage
		            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		            bufferedImage.getGraphics().drawImage(image, 0, 0, null);
		            File tempFile = new File("temp_image.jpg");
		            try {
		            	ImageIO.write(bufferedImage, "jpg", tempFile);
		                thumbnail = CloudinaryUploaderUtils.uploadImage(tempFile);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
		        }
                
		        
		        String userId = controller.addUserAndReturnID(fullname, username, thumbnail, yearold, email, phoneNumber, password, status, role);
		        if (userId != null) {
		        	button_1.setEnabled(false);
			    	button_2.setEnabled(false);
			    	ScannerUtils.clearForm(textField_1, textField_2, textField_3, textField_4, textField_5);
		            loadUserData();
		            ScannerUtils.showSuccessMessage(Panel_ManagerUser.this, "Thêm dữ liệu thành công!");
		        }
		    }
		});
		
		//Bắt sự kiện nút sửa
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow(); 
				String userId = table.getValueAt(selectedRow, 0).toString();
				String fullname = textField_1.getText();
				String username = textField_2.getText();
				String yearold = textField_3.getText();
				String phoneNumber = textField_4.getText();
				String email = textField_5.getText();
				String statusString = (String) comboBoxStatus.getSelectedItem();
		        String roleString = (String) comboBoxRole.getSelectedItem();
		        
		        Status status = Status.ACTIVE;
		        if(statusString.equals("DỪNG HOẠT ĐỘNG")) {
		        	status = Status.INACTIVE;
		        } else if(statusString.equals("ĐANG BẢO TRÌ")) {
		        	status = Status.MAINTENANCE;
		        }
				
				Role role = Role.LECTURER; 
		        if (roleString.equals("BẢO TRÌ")) {
		            role = Role.MAINTENANCE;	
		        }
				
				User manager = new Manager(fullname, username, null, yearold, email, phoneNumber, null, status,  role, userId);
				String editSuccess = controller.edit(manager);
				if(editSuccess == "SUCCESS") {
					button.setEnabled(true);
					button_1.setEnabled(false);
			    	button_2.setEnabled(false);
			    	ScannerUtils.clearForm(textField_1, textField_2, textField_3, textField_4, textField_5);
					loadUserData();
					ScannerUtils.showSuccessMessage(Panel_ManagerUser.this, "Cập nhật thành công!");
				} else if(editSuccess == "UNSUCCESS"){
					ScannerUtils.showErrorMessage(Panel_ManagerUser.this, "Cập nhật không thành công!");
				}
				
			}
		});
		
		//Bắt sự kiện nút xóa
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String userId = table.getValueAt(selectedRow, 0).toString();
				PageManager pageManager = new PageManager();
				Boolean deleteSuccess = controller.delete(userId, pageManager);
				if(deleteSuccess) {
					button.setEnabled(true);
					button_1.setEnabled(false);
			    	button_2.setEnabled(false);
					ScannerUtils.clearForm(textField_1, textField_2, textField_3, textField_4, textField_5);
					loadUserData();
					ScannerUtils.showSuccessMessage(Panel_ManagerUser.this, "Xóa thành công!");
				} else {
					ScannerUtils.showErrorMessage(Panel_ManagerUser.this, "Xóa không thành công!");
				}
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	button.setEnabled(false);
		    	button_1.setEnabled(true);
		    	button_2.setEnabled(true);
		        int selectedRow = table.getSelectedRow(); 
		        if (selectedRow >= 0) {
		            String fullname = table.getValueAt(selectedRow, 2).toString();
		            String username = table.getValueAt(selectedRow, 3).toString();
		            String yearold = table.getValueAt(selectedRow, 4).toString();
		            String phoneNumber = table.getValueAt(selectedRow, 5).toString();
		            String email = table.getValueAt(selectedRow, 6).toString();
		            String status = table.getValueAt(selectedRow, 7).toString();
		            String role = table.getValueAt(selectedRow, 8).toString();
		            
		            textField_1.setText(fullname);
		            textField_2.setText(username);
		            textField_3.setText(yearold);
		            textField_4.setText(phoneNumber);
		            textField_5.setText(email);
		            
		            for (int i = 0; i < comboBoxStatus.getItemCount(); i++) {
		                if (status.equals(comboBoxStatus.getItemAt(i))) {
		                    comboBoxStatus.setSelectedIndex(i);
		                    break;
		                }
		            }
		            
		            for (int i = 0; i < comboBoxRole.getItemCount(); i++) {
		                if (role.equals(comboBoxRole.getItemAt(i))) {
		                	comboBoxRole.setSelectedIndex(i);
		                    break; 
		                }
		            }
		        }
		    }
		});
		
	}
	
	//Hàm load lại dữ liệu
	public void loadUserData() {
        List<User> users = controller.getAllUsers();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (User user : users) {
        	String roleDisplay = user.getRole().name();
        	String statusDisplay = user.getStatus().name();
        	
        	if(user.getStatus().name() == "ACTIVE") {
        		statusDisplay = "HOẠT ĐỘNG";
        	} else if(user.getStatus().name() == "INACTIVE") {
        		statusDisplay = "DỪNG HOẠT ĐỘNG";
        	} else if(user.getStatus().name() == "MAINTENANCE"){
        		statusDisplay = "ĐANG BẢO TRÌ";
        	}

            if (user.getRole() == Role.LECTURER) {
                roleDisplay = "GIÁO VIÊN";
            } else if(user.getRole() == Role.MAINTENANCE) {
            	roleDisplay = "BẢO TRÌ";
            }
            
            try {
	            URL imageUrl = new URL(user.getThumbnail());
	            ImageIcon imageIcon = new ImageIcon(imageUrl);
	            Image image = imageIcon.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
	            imageIcon = new ImageIcon(image);
	        	
	            model.addRow(new Object[]{
	            	user.getUserId(),
		            imageIcon,
	                user.getFullname(),
	                user.getUsername(),
	                user.getYearold(),
	                user.getPhoneNumber(),
	                user.getEmail(),
	                statusDisplay,
	                roleDisplay
	            });
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        
        TableColumn imageColumn = table.getColumnModel().getColumn(1); 
        imageColumn.setCellRenderer(new ImageRenderer());
    }
}
