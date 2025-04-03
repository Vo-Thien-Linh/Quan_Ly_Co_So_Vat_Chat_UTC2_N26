package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;

public class Panel_ManagerUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		gbl_panel.rowHeights = new int[]{84, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("ID người dùng: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblHVTn = new JLabel("Họ và tên: ");
		lblHVTn.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHVTn = new GridBagConstraints();
		gbc_lblHVTn.anchor = GridBagConstraints.EAST;
		gbc_lblHVTn.insets = new Insets(0, 0, 5, 5);
		gbc_lblHVTn.gridx = 0;
		gbc_lblHVTn.gridy = 1;
		panel_2.add(lblHVTn, gbc_lblHVTn);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_2.add(textField_1, gbc_textField_1);
		
		JLabel lblPhi = new JLabel("Phái: ");
		lblPhi.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPhi = new GridBagConstraints();
		gbc_lblPhi.anchor = GridBagConstraints.EAST;
		gbc_lblPhi.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhi.gridx = 0;
		gbc_lblPhi.gridy = 2;
		panel_2.add(lblPhi, gbc_lblPhi);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_2.add(textField_2, gbc_textField_2);
		
		JLabel lblNgySinh = new JLabel("Ngày tháng năm sinh: ");
		lblNgySinh.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNgySinh = new GridBagConstraints();
		gbc_lblNgySinh.anchor = GridBagConstraints.EAST;
		gbc_lblNgySinh.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgySinh.gridx = 0;
		gbc_lblNgySinh.gridy = 3;
		panel_2.add(lblNgySinh, gbc_lblNgySinh);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_2.add(textField_3, gbc_textField_3);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại: ");
		lblSinThoi.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblSinThoi = new GridBagConstraints();
		gbc_lblSinThoi.anchor = GridBagConstraints.EAST;
		gbc_lblSinThoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinThoi.gridx = 0;
		gbc_lblSinThoi.gridy = 4;
		panel_2.add(lblSinThoi, gbc_lblSinThoi);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panel_2.add(textField_4, gbc_textField_4);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		panel_2.add(lblEmail, gbc_lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		panel_2.add(textField_5, gbc_textField_5);
		
		JLabel lblVaiTr = new JLabel("Vai trò: ");
		lblVaiTr.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVaiTr = new GridBagConstraints();
		gbc_lblVaiTr.anchor = GridBagConstraints.EAST;
		gbc_lblVaiTr.insets = new Insets(0, 0, 0, 5);
		gbc_lblVaiTr.gridx = 0;
		gbc_lblVaiTr.gridy = 6;
		panel_2.add(lblVaiTr, gbc_lblVaiTr);
		
		Choice choice = new Choice();
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.anchor = GridBagConstraints.WEST;
		gbc_choice.gridx = 1;
		gbc_choice.gridy = 6;
		panel_2.add(choice, gbc_choice);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID User", "Họ và tên", "Phái", "Ngày tháng năm sinh","Số điện thoại", "Email", "Vai trò"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 240));
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{85, 85, 85, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Button button = new Button("Thêm");
		button.setFont(new Font("Arial", Font.PLAIN, 20));
		button.setBackground(new Color(144, 238, 144));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);
		
		Button button_1 = new Button("Sửa");
		button_1.setFont(new Font("Arial", Font.PLAIN, 20));
		button_1.setForeground(new Color(255, 215, 0));
		button_1.setBackground(new Color(255, 250, 205));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel_1.add(button_1, gbc_button_1);
		
		Button button_2 = new Button("Xóa");
		button_2.setFont(new Font("Arial", Font.PLAIN, 20));
		button_2.setBackground(new Color(250, 128, 114));
		button_2.setForeground(new Color(178, 34, 34));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		panel_1.add(button_2, gbc_button_2);

	}

}
