package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JPasswordField;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Button;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1149, 833);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setForeground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Đăng ký tài khoản");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 40));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Register.class.getResource("/view/img/logo-utc.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{508, 508, 0};
		gbl_panel.rowHeights = new int[]{37, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập: ");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{508, 508, 0};
		gbl_panel_1.rowHeights = new int[]{37, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày tháng năm sinh:");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2_1.gridx = 0;
		gbc_lblNewLabel_2_1.gridy = 0;
		panel_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 25));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 248, 220));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{508, 508, 0};
		gbl_panel_2.rowHeights = new int[]{37, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email:");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2_2.gridx = 0;
		gbc_lblNewLabel_2_2.gridy = 0;
		panel_2.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 25));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_2.add(textField_2, gbc_textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 248, 220));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 5;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{508, 508, 0};
		gbl_panel_3.rowHeights = new int[]{37, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Số điện thoại:");
		lblNewLabel_2_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_3.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2_3.gridx = 0;
		gbc_lblNewLabel_2_3.gridy = 0;
		panel_3.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 25));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel_3.add(textField_3, gbc_textField_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 248, 220));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 6;
		contentPane.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{508, 508, 0};
		gbl_panel_4.rowHeights = new int[]{37, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("Mật khẩu:");
		lblNewLabel_2_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_4.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2_4 = new GridBagConstraints();
		gbc_lblNewLabel_2_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2_4.gridx = 0;
		gbc_lblNewLabel_2_4.gridy = 0;
		panel_4.add(lblNewLabel_2_4, gbc_lblNewLabel_2_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 0;
		panel_4.add(passwordField, gbc_passwordField);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 7;
		contentPane.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{508, 508, 0};
		gbl_panel_5.rowHeights = new int[]{37, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("Chức vụ:");
		lblNewLabel_2_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_5.setFont(new Font("Calibri", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_2_5 = new GridBagConstraints();
		gbc_lblNewLabel_2_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2_5.gridx = 0;
		gbc_lblNewLabel_2_5.gridy = 0;
		panel_5.add(lblNewLabel_2_5, gbc_lblNewLabel_2_5);
		
		Choice choice = new Choice();
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.anchor = GridBagConstraints.WEST;
		gbc_choice.gridx = 1;
		gbc_choice.gridy = 0;
		panel_5.add(choice, gbc_choice);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 250, 205));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 8;
		contentPane.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{508, 508, 0};
		gbl_panel_6.rowHeights = new int[]{37, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		Button button = new Button("Đăng Ký");
		button.setForeground(new Color(255, 250, 205));
		button.setBackground(new Color(0, 128, 0));
		button.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_6.add(button, gbc_button);
		
		Button button_1 = new Button("Đăng nhập");
		button_1.setForeground(new Color(255, 250, 205));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		panel_6.add(button_1, gbc_button_1);
	}

}