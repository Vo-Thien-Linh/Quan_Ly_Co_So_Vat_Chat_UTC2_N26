package View;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;

public class Panel_RentRoom extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Panel_RentRoom() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(255, 250, 250));
		scrollPane.setBackground(new Color(0, 0, 139));
		scrollPane.setBounds(10, 330, 1000, 374);
		add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 250, 250));
		table.setBackground(new Color(65, 105, 225));
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Số Phòng", "Sức chứa"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ID Phòng:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(85, 39, 243, 31);
		add(lblNewLabel);
		
		JLabel lblNgyMn = new JLabel("Ngày mượn:");
		lblNgyMn.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNgyMn.setBounds(85, 97, 243, 31);
		add(lblNgyMn);
		
		JLabel lblNgyTr = new JLabel("Ngày Trả:");
		lblNgyTr.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNgyTr.setBounds(85, 170, 243, 31);
		add(lblNgyTr);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(338, 39, 227, 31);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(338, 97, 227, 31);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(338, 159, 227, 31);
		add(textField_2);
		
		Button button = new Button("Xác nhận mượn");
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(688, 80, 140, 31);
		add(button);

	}
}
