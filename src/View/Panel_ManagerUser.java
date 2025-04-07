package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.table.DefaultTableModel;

import Controller.ManagerUserController;
import Controller.UserController;
import Model.Admin;
import Model.Manager;
import Model.Role;
import Model.Status;
import Model.User;
import utils.DateUtils;
import utils.PasswordGeneratorUtils;
import utils.ScannerUtils;

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
		
		JLabel lblPhi = new JLabel("Tên đăng nhập: ");
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
		
		JLabel lblStatus = new JLabel("Trạng thái: ");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 6;
		panel_2.add(lblStatus, gbc_lblStatus);
		
		Choice choice_1 = new Choice();
		for (Status status : Status.values()) {
			if(status.name() == "MAINTENANCE") {
				choice_1.add("ĐANG BẢO TRÌ");
			} else if(status.name() == "ACTIVE") {
				choice_1.add("HOẠT ĐỘNG");
			} else {
				choice_1.add("DỪNG HOẠT ĐỘNG");
			}
		}
		GridBagConstraints gbc_choice_1 = new GridBagConstraints();
		gbc_choice_1.anchor = GridBagConstraints.WEST;
		gbc_choice_1.gridx = 1;
		gbc_choice_1.gridy = 6;
		panel_2.add(choice_1, gbc_choice_1);
		
		JLabel lblVaiTr = new JLabel("Vai trò: ");
		lblVaiTr.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVaiTr = new GridBagConstraints();
		gbc_lblVaiTr.anchor = GridBagConstraints.EAST;
		gbc_lblVaiTr.insets = new Insets(0, 0, 0, 5);
		gbc_lblVaiTr.gridx = 0;
		gbc_lblVaiTr.gridy = 7;
		panel_2.add(lblVaiTr, gbc_lblVaiTr);
		
		Choice choice_2 = new Choice();
		for (Role role : Role.values()) {
			if(role.name() == "MAINTENANCE") {
				choice_2.add("BẢO TRÌ");
			} else {
				choice_2.add("GIÁO VIÊN");
			}
		}
		GridBagConstraints gbc_choice_2 = new GridBagConstraints();
		gbc_choice_2.anchor = GridBagConstraints.WEST;
		gbc_choice_2.gridx = 1;
		gbc_choice_2.gridy = 7;
		panel_2.add(choice_2, gbc_choice_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã người dùng","Họ và tên", "Tên đăng nhập", "Ngày tháng năm sinh","Số điện thoại", "Email", "Trạng thái", "Vai trò"
			}
		));
		scrollPane.setViewportView(table);
		controller = new ManagerUserController(null, null);
        loadUserData();
		
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
		button_1.setEnabled(false);
		
		Button button_2 = new Button("Xóa");
		button_2.setFont(new Font("Arial", Font.PLAIN, 20));
		button_2.setBackground(new Color(250, 128, 114));
		button_2.setForeground(new Color(178, 34, 34));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		panel_1.add(button_2, gbc_button_2);
		button_2.setEnabled(false);
		
		//Bắt sự kiện nút thêm
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String fullname = textField_1.getText();
		        String username = textField_2.getText(); 
		        String yearold = textField_3.getText();
		        String phoneNumber = textField_4.getText();
		        new PasswordGeneratorUtils();
				String password = PasswordGeneratorUtils.generateStrongPassword();
		        String email = textField_5.getText(); 
		        String statusString = choice_1.getSelectedItem();
		        String roleString = choice_2.getSelectedItem();
		        
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
		        
		        PageManager pageManager = new PageManager();
		        if (ScannerUtils.isEmpty(fullname, username, yearold, phoneNumber, email)) {
		        	ScannerUtils.showErrorMessage(pageManager, "Vui lòng điền đầy đủ thông tin!");
		            return;
		        }

		        String userId = controller.addUserAndReturnID(fullname, username, yearold, email, phoneNumber, password, status, role);
		        if (userId != null) {
		        	button_1.setEnabled(false);
			    	button_2.setEnabled(false);
		        	clearForm();
		            loadUserData();
		            ScannerUtils.showSuccessMessage(pageManager, "Thêm dữ liệu thành công!");
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
				String statusString = choice_1.getSelectedItem();
		        String roleString = choice_2.getSelectedItem();
		        
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
				
				User manager = new Manager(fullname, username, yearold, email, phoneNumber, null, status,  role, userId);
				String editSuccess = controller.edit(manager);
				if(editSuccess == "SUCCESS") {
					button_1.setEnabled(false);
			    	button_2.setEnabled(false);
					clearForm();
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
					button_1.setEnabled(false);
			    	button_2.setEnabled(false);
					clearForm();
					loadUserData();
					ScannerUtils.showSuccessMessage(Panel_ManagerUser.this, "Xóa thành công!");
				} else {
					ScannerUtils.showErrorMessage(Panel_ManagerUser.this, "Xóa không thành công!");
				}
			}
		});
		
		// Bắt sự kiện khi click vào bảng và hiển thị dữ liệu dòng được chọn vào các ô input
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	button_1.setEnabled(true);
		    	button_2.setEnabled(true);
		        int selectedRow = table.getSelectedRow(); 
		        if (selectedRow >= 0) {
		            String fullname = table.getValueAt(selectedRow, 1).toString();
		            String username = table.getValueAt(selectedRow, 2).toString();
		            String yearold = table.getValueAt(selectedRow, 3).toString();
		            String phoneNumber = table.getValueAt(selectedRow, 4).toString();
		            String email = table.getValueAt(selectedRow, 5).toString();
		            String status = table.getValueAt(selectedRow, 6).toString();
		            String role = table.getValueAt(selectedRow, 7).toString();
		            
		            textField_1.setText(fullname);
		            textField_2.setText(username);
		            textField_3.setText(yearold);
		            textField_4.setText(phoneNumber);
		            textField_5.setText(email);
		            
		            if (status.equals("HOẠT ĐỘNG")) {
		            	choice_1.select("HOẠT ĐỘNG");
		            } else if(status.equals("DỪNG HOẠT ĐỘNG")){
		            	choice_1.select("DỪNG HOẠT ĐỘNG");
		            } else {
		            	choice_1.select("ĐANG BẢO TRÌ");
		            }
		            
		            if (role.equals("BẢO TRÌ")) {
		            	choice_2.select("BẢO TRÌ");
		            } else {
		            	choice_2.select("GIÁO VIÊN");
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
        	
            model.addRow(new Object[]{
            	user.getUserId(),
                user.getFullname(),
                user.getUsername(),
                user.getYearold(),
                user.getPhoneNumber(),
                user.getEmail(),
                statusDisplay,
                roleDisplay
            });
        }
    }
	
	public void clearForm() {
		textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
	}
}
