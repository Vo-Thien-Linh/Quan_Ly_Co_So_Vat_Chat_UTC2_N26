package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PageManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

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
		setForeground(new Color(25, 25, 112));
		setFont(new Font("Courier New", Font.BOLD, 15));
		setTitle("Quản lý cơ sở vật chất UTC2 - Quản lý");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PageManager.class.getResource("/View/IMG/logo-utc.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1165, 649);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Quản lý cơ sở vật chất UTC2");
		lblNewLabel.setBackground(new Color(255, 250, 240));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(PageManager.class.getResource("/view/img/logo-utc (1).png")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Tài Khoản");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setIcon(new ImageIcon(PageManager.class.getResource("/view/img/account-icon1.jpg")));
		panel.add(btnNewButton_3, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 240));
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Button button = new Button("Danh sách đơn mượn");
		button.setFont(new Font("Courier New", Font.BOLD, 18));
		button.setBackground(new Color(255, 255, 224));
		button.setForeground(new Color(25, 25, 112));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);
		
		Button button_1 = new Button("Thêm đơn mượn phòng");
		button_1.setForeground(new Color(25, 25, 112));
		button_1.setBackground(new Color(135, 206, 250));
		button_1.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel_1.add(button_1, gbc_button_1);
		
		Button button_2 = new Button("Chỉnh sửa đơn mượn");
		button_2.setForeground(new Color(25, 25, 112));
		button_2.setFont(new Font("Courier New", Font.BOLD, 18));
		button_2.setBackground(new Color(135, 206, 250));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		panel_1.add(button_2, gbc_button_2);
		
		Button button_3 = new Button("Duyệt đơn mượn");
		button_3.setForeground(new Color(25, 25, 112));
		button_3.setBackground(new Color(135, 206, 250));
		button_3.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 3;
		panel_1.add(button_3, gbc_button_3);
		
		Button button_4 = new Button("Cập nhật đơn mượn");
		button_4.setForeground(new Color(25, 25, 112));
		button_4.setBackground(new Color(135, 206, 250));
		button_4.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 4;
		panel_1.add(button_4, gbc_button_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "name_82703093362400");
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{305, 305, 305, 0};
		gbl_panel_6.rowHeights = new int[]{23, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm: ");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_6.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_6.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(null);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_6.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.CENTER);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.NORTH;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel_7.add(table, gbc_table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 1;
		panel_7.add(table_1, gbc_table_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_5, "name_82779873344400");
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{687, 0};
		gbl_panel_5.rowHeights = new int[]{0, 429, 19, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Thêm đơn mượn phòng");
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_5.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{343, 409, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 50, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblNewLabel_3 = new JLabel("ID đơn: ");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_8.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_8.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID Phòng: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_8.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel_8.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Người mượn: ");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_8.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 2;
		panel_8.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày mượn: ");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		panel_8.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		panel_8.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Thời gian mượn: ");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		panel_8.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 4;
		panel_8.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày trả: ");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		panel_8.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 5;
		panel_8.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Giờ trả: ");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 6;
		panel_8.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 6;
		panel_8.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Lý do mượn:");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 7;
		panel_8.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 7;
		panel_8.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Trạng thái:");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 8;
		panel_8.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_17 = new GridBagConstraints();
		gbc_textField_17.anchor = GridBagConstraints.WEST;
		gbc_textField_17.gridx = 1;
		gbc_textField_17.gridy = 8;
		panel_8.add(textField_17, gbc_textField_17);
		textField_17.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Xác nhận");
		btnNewButton_1.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		panel_5.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_5_1, "name_598915942400");
		GridBagLayout gbl_panel_5_1 = new GridBagLayout();
		gbl_panel_5_1.columnWidths = new int[]{687, 0};
		gbl_panel_5_1.rowHeights = new int[]{0, 429, 19, 0};
		gbl_panel_5_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5_1.setLayout(gbl_panel_5_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(" Chỉnh sửa đơn mượn phòng");
		lblNewLabel_2_1.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 0;
		panel_5_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(220, 220, 220));
		GridBagConstraints gbc_panel_8_1 = new GridBagConstraints();
		gbc_panel_8_1.fill = GridBagConstraints.BOTH;
		gbc_panel_8_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8_1.gridx = 0;
		gbc_panel_8_1.gridy = 1;
		panel_5_1.add(panel_8_1, gbc_panel_8_1);
		GridBagLayout gbl_panel_8_1 = new GridBagLayout();
		gbl_panel_8_1.columnWidths = new int[]{343, 409, 0};
		gbl_panel_8_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 50, 0};
		gbl_panel_8_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_8_1.setLayout(gbl_panel_8_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("ID đơn: ");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 0;
		panel_8_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.anchor = GridBagConstraints.WEST;
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 0;
		panel_8_1.add(textField_9, gbc_textField_9);
		
		JLabel lblNewLabel_4_1 = new JLabel("ID Phòng: ");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 1;
		panel_8_1.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.anchor = GridBagConstraints.WEST;
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 1;
		panel_8_1.add(textField_10, gbc_textField_10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Người mượn: ");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1.gridx = 0;
		gbc_lblNewLabel_5_1.gridy = 2;
		panel_8_1.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.anchor = GridBagConstraints.WEST;
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 2;
		panel_8_1.add(textField_11, gbc_textField_11);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ngày mượn: ");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_6_1 = new GridBagConstraints();
		gbc_lblNewLabel_6_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6_1.gridx = 0;
		gbc_lblNewLabel_6_1.gridy = 3;
		panel_8_1.add(lblNewLabel_6_1, gbc_lblNewLabel_6_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.anchor = GridBagConstraints.WEST;
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 3;
		panel_8_1.add(textField_12, gbc_textField_12);
		
		JLabel lblNewLabel_7_1 = new JLabel("Thời gian mượn: ");
		lblNewLabel_7_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_7_1 = new GridBagConstraints();
		gbc_lblNewLabel_7_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_1.gridx = 0;
		gbc_lblNewLabel_7_1.gridy = 4;
		panel_8_1.add(lblNewLabel_7_1, gbc_lblNewLabel_7_1);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_13.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.anchor = GridBagConstraints.WEST;
		gbc_textField_13.insets = new Insets(0, 0, 5, 0);
		gbc_textField_13.gridx = 1;
		gbc_textField_13.gridy = 4;
		panel_8_1.add(textField_13, gbc_textField_13);
		
		JLabel lblNewLabel_8_1 = new JLabel("Ngày trả: ");
		lblNewLabel_8_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_8_1 = new GridBagConstraints();
		gbc_lblNewLabel_8_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8_1.gridx = 0;
		gbc_lblNewLabel_8_1.gridy = 5;
		panel_8_1.add(lblNewLabel_8_1, gbc_lblNewLabel_8_1);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_14.setColumns(10);
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.anchor = GridBagConstraints.WEST;
		gbc_textField_14.insets = new Insets(0, 0, 5, 0);
		gbc_textField_14.gridx = 1;
		gbc_textField_14.gridy = 5;
		panel_8_1.add(textField_14, gbc_textField_14);
		
		JLabel lblNewLabel_9_1 = new JLabel("Giờ trả: ");
		lblNewLabel_9_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_9_1 = new GridBagConstraints();
		gbc_lblNewLabel_9_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9_1.gridx = 0;
		gbc_lblNewLabel_9_1.gridy = 6;
		panel_8_1.add(lblNewLabel_9_1, gbc_lblNewLabel_9_1);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_15.setColumns(10);
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.anchor = GridBagConstraints.WEST;
		gbc_textField_15.insets = new Insets(0, 0, 5, 0);
		gbc_textField_15.gridx = 1;
		gbc_textField_15.gridy = 6;
		panel_8_1.add(textField_15, gbc_textField_15);
		
		JLabel lblNewLabel_10_1 = new JLabel("Lý do mượn:");
		lblNewLabel_10_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_10_1 = new GridBagConstraints();
		gbc_lblNewLabel_10_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10_1.gridx = 0;
		gbc_lblNewLabel_10_1.gridy = 7;
		panel_8_1.add(lblNewLabel_10_1, gbc_lblNewLabel_10_1);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_16.setColumns(10);
		GridBagConstraints gbc_textField_16 = new GridBagConstraints();
		gbc_textField_16.anchor = GridBagConstraints.WEST;
		gbc_textField_16.insets = new Insets(0, 0, 5, 0);
		gbc_textField_16.gridx = 1;
		gbc_textField_16.gridy = 7;
		panel_8_1.add(textField_16, gbc_textField_16);
		
		JLabel lblNewLabel_12 = new JLabel("Trạng thái: ");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 8;
		panel_8_1.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_18 = new GridBagConstraints();
		gbc_textField_18.anchor = GridBagConstraints.WEST;
		gbc_textField_18.gridx = 1;
		gbc_textField_18.gridy = 8;
		panel_8_1.add(textField_18, gbc_textField_18);
		textField_18.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("Cập nhật");
		btnNewButton_1_1.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.gridx = 0;
		gbc_btnNewButton_1_1.gridy = 2;
		panel_5_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9, "name_1000786317300");
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblNewLabel_13 = new JLabel("Duyệt đơn mượn phòng");
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 0;
		panel_9.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 1;
		panel_9.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0};
		gbl_panel_10.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11, "name_1666378497500");
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0};
		gbl_panel_11.rowHeights = new int[]{0, 0, 0};
		gbl_panel_11.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JLabel lblNewLabel_14 = new JLabel("Cập nhật đơn mượn");
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 0;
		panel_11.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 1;
		panel_11.add(panel_12, gbc_panel_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 250, 240));
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_4 = new JButton("Đăng xuất");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_3.add(btnNewButton_4, BorderLayout.WEST);
	}
}
