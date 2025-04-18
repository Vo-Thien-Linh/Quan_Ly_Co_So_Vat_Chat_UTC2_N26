package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import Controller.ManagerDeviceController;
import Model.Device;
import Model.DeviceStatus;
import Model.Room;
import utils.ScannerUtils;
import java.awt.Color;
import java.awt.Button;
import java.awt.Choice;

public class Panel_ManagerDevice extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ManagerDeviceController controller;

	public Panel_ManagerDevice() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{890, 0};
		gbl_panel.rowHeights = new int[]{139, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 245, 220));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{50, 50, 50, 50, 50, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Tên thiết bị: ");
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
		
		JLabel lblTnThitB = new JLabel("Loại thiết bị: ");
		lblTnThitB.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTnThitB = new GridBagConstraints();
		gbc_lblTnThitB.anchor = GridBagConstraints.EAST;
		gbc_lblTnThitB.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnThitB.gridx = 0;
		gbc_lblTnThitB.gridy = 1;
		panel_2.add(lblTnThitB, gbc_lblTnThitB);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_2.add(textField_1, gbc_textField_1);
		
		JLabel lblSLng = new JLabel("Ngày mua: ");
		lblSLng.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblSLng = new GridBagConstraints();
		gbc_lblSLng.anchor = GridBagConstraints.EAST;
		gbc_lblSLng.insets = new Insets(0, 0, 5, 5);
		gbc_lblSLng.gridx = 0;
		gbc_lblSLng.gridy = 2;
		panel_2.add(lblSLng, gbc_lblSLng);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_2.add(textField_2, gbc_textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nhà cung cấp: ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_2.add(textField_3, gbc_textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Giá: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 0;
		panel_2.add(textField_4, gbc_textField_4);
		
		JLabel lblStatus = new JLabel("Trạng thái: ");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatus.gridx = 2;
		gbc_lblStatus.gridy = 1;
		panel_2.add(lblStatus, gbc_lblStatus);
		
		Choice choice_1 = new Choice();
		for (DeviceStatus status : DeviceStatus.values()) {
			if(status.name() == "AVAILABLE") {
				choice_1.add("CÓ SẴN");
			} else if(status.name() == "UNAVAILABLE") {
				choice_1.add("KHÔNG CÓ SẴN");
			} else if(status.name() == "UNDER_MAINTENANCE") {
				choice_1.add("ĐANG BẢO TRÌ");
			} else if(status.name() == "BROKEN") {
				choice_1.add("BỊ HỎNG");
			} else {
				choice_1.add("LOẠI BỎ");
			}
		}
		GridBagConstraints gbc_choice_1 = new GridBagConstraints();
		gbc_choice_1.anchor = GridBagConstraints.WEST;
		gbc_choice_1.gridx = 3;
		gbc_choice_1.gridy = 1;
		panel_2.add(choice_1, gbc_choice_1);
		
		JLabel lblRoom = new JLabel("Phòng: ");
		lblRoom.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.insets = new Insets(0, 0, 0, 5);
		gbc_lblRoom.gridx = 2;
		gbc_lblRoom.gridy = 2;
		panel_2.add(lblRoom, gbc_lblRoom);

		JComboBox<Room> comboBoxRoom = new JComboBox<>();
		loadRoomData(comboBoxRoom);

		GridBagConstraints gbc_comboBoxRoom = new GridBagConstraints();
		gbc_comboBoxRoom.anchor = GridBagConstraints.WEST;
		gbc_comboBoxRoom.gridx = 3;
		gbc_comboBoxRoom.gridy = 2;
		panel_2.add(comboBoxRoom, gbc_comboBoxRoom);
		
		JLabel lblNewLabel_5 = new JLabel("Số lượng: ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 3;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 3;
		panel_2.add(textField_5, gbc_textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Mã thiết bị", "Tên thiết bị", "Loại thiết bị", "Ngày mua" , "Nhà cung cấp",  "Giá", "Trạng thái", "Phòng", "Số lượng",
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{85, 85, 85, 85, 85, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Button button = new Button("Thêm");
		button.setForeground(new Color(34, 139, 34));
		button.setBackground(new Color(144, 238, 144));
		button.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);
		
		Button button_2 = new Button("Sửa");
		button_2.setForeground(new Color(255, 215, 0));
		button_2.setBackground(new Color(255, 250, 205));
		button_2.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		button_2.setEnabled(false);
		
		Button button_1 = new Button("Xóa");
		button_1.setForeground(new Color(178, 34, 34));
		button_1.setBackground(new Color(250, 128, 114));
		button_1.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 2;
		panel_1.add(button_1, gbc_button_1);
		button_1.setEnabled(false);
		
		Button button_3 = new Button("Duyệt đơn mượn thiết bị");
		button_3.setBackground(new Color(135, 206, 250));
		button_3.setForeground(new Color(0, 0, 205));
		button_3.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.BOTH;
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 3;
		panel_1.add(button_3, gbc_button_3);
		button_3.setEnabled(false);
		
		Button button_4 = new Button("Xuất hóa đơn");
		button_4.setForeground(new Color(255, 255, 0));
		button_4.setBackground(new Color(0, 100, 0));
		button_4.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 0);
		gbc_button_4.fill = GridBagConstraints.BOTH;
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 4;
		panel_1.add(button_4, gbc_button_4);
		button_4.setEnabled(false);
		loadDeviceData();
		
//		Bắt sự kiện nút thêm
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deviceName = textField.getText();
				String deviceType = textField_1.getText();
				String purchaseDateStr = textField_2.getText();
				String supplier = textField_3.getText();
				String priceStr = textField_4.getText();
				String statusStr = choice_1.getSelectedItem();
				Room room = (Room) comboBoxRoom.getSelectedItem();
				String quantityStr = textField_5.getText();
				
				if(ScannerUtils.isEmpty(deviceName, deviceType, purchaseDateStr, supplier, priceStr, quantityStr, room, quantityStr)) {
		        	ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Vui lòng điền đầy đủ thông tin!");
		            return;
		        }
				
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate purchaseDate = null;

				try {
				    purchaseDate = LocalDate.parse(purchaseDateStr, inputFormatter);
				} catch (DateTimeParseException ex) {
				    ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Ngày không hợp lệ. Định dạng đúng: dd/MM/yyyy");
				    return;
				}


		       BigDecimal price;
		        try {
		        	price = new BigDecimal(priceStr);
		        } catch (NumberFormatException ex) {
		        	ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Giá không hợp lệ!");
		            return;
		        }
		        
		        DeviceStatus status = DeviceStatus.AVAILABLE;
		        if(statusStr.equals("Không có sẵn")) {
		        	status = DeviceStatus.UNAVAILABLE;
		        } else if(statusStr.equals("Đang bảo trì")) {
		        	status = DeviceStatus.UNDER_MAINTENANCE;
		        } else if(statusStr.equals("Bị hỏng")) {
		        	status = DeviceStatus.BROKEN;
		        } else if(statusStr.equals("Loại bỏ")){
		        	status = DeviceStatus.DISCARDED;
		        }
		        

		        int quantity = 0;
		        try {
		            quantity = Integer.parseInt(quantityStr);
		        } catch (NumberFormatException ex) {
		        	ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Số lượng không hợp lệ!");
		            return;
		        }
		        
		        
		        Device device = new Device(null, deviceName, deviceType, purchaseDate, supplier, price, status, room, quantity);
		        Boolean deviceId = controller.addDeviceAndReturnId(device);
		        if(deviceId) {
		        	button.setEnabled(true);
		        	button_1.setEnabled(false);
		        	button_2.setEnabled(false);
		        	button_3.setEnabled(false);
		        	button_4.setEnabled(false);
		        	loadDeviceData();
		        	ScannerUtils.clearForm(textField, textField_1, textField_2, textField_3, textField_4, textField_5);
		        	ScannerUtils.showSuccessMessage(Panel_ManagerDevice.this, "Thêm dữ liệu thành công!");
		        } else {
		        	ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Thêm dữ liệu không thành công!");
		        }
			}
		});
		
//		Bắt sự kiện nút sửa
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow(); 
				String deviceId = table.getValueAt(selectedRow, 0).toString();
				String deviceName = textField.getText();
				String deviceType = textField_1.getText();
				String purchaseDateStr = textField_2.getText();
				String supplier = textField_3.getText();
				BigDecimal price = new BigDecimal(textField_4.getText());
				String statusStr = choice_1.getSelectedItem();
				Room room = (Room) comboBoxRoom.getSelectedItem();
				String quantityStr = textField_5.getText();
				
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate purchaseDate = null;
				try {
				    purchaseDate = LocalDate.parse(purchaseDateStr, inputFormatter);
				} catch (DateTimeParseException ex) {
				    ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Ngày không hợp lệ. Định dạng đúng: dd/MM/yyyy");
				    return;
				}

		        
		        DeviceStatus status = DeviceStatus.AVAILABLE;
		        if(statusStr.equals("KHÔNG CÓ SẴN")) {
		        	status = DeviceStatus.UNAVAILABLE;
		        } else if(statusStr.equals("ĐANG BẢO TRÌ")) {
		        	status = DeviceStatus.UNDER_MAINTENANCE;
		        } else if(statusStr.equals("BỊ HỎNG")) {
		        	status = DeviceStatus.BROKEN;
		        } else if(statusStr.equals("LOẠI BỎ")){
		        	status = DeviceStatus.DISCARDED;
		        }
		        

		        int quantity = 0;
		        try {
		            quantity = Integer.parseInt(quantityStr);
		        } catch (NumberFormatException ex) {
		        	ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Số lượng không hợp lệ!");
		            return;
		        }
		        
		        Device device = new Device(deviceId, deviceName, deviceType, purchaseDate, supplier, price, status, room, quantity);
		        Boolean editSuccess = controller.edit(device);
		        if(editSuccess) {
		        	button.setEnabled(true);
		        	button_1.setEnabled(false);
		        	button_2.setEnabled(false);
		        	button_3.setEnabled(false);
		        	button_4.setEnabled(false);
		        	loadDeviceData();
		        	ScannerUtils.clearForm(textField, textField_1, textField_2, textField_3, textField_4, textField_5);
		        	ScannerUtils.showSuccessMessage(Panel_ManagerDevice.this, "Chỉnh sửa thành công!");
		        } else {
		        	ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Chỉnh sửa Không thành công!");
		        }
			}
		});
		
//		Bắt sự kiện nút xóa
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow(); 
				String deviceId = table.getValueAt(selectedRow, 0).toString();
				
				Boolean deleteSuccess = controller.delete(deviceId);
				if(deleteSuccess) {
					button.setEnabled(true);
		        	button_1.setEnabled(false);
		        	button_2.setEnabled(false);
		        	button_3.setEnabled(false);
		        	button_4.setEnabled(false);
		        	loadDeviceData();
		        	ScannerUtils.clearForm(textField, textField_1, textField_2, textField_3, textField_4, textField_5);
					ScannerUtils.showSuccessMessage(Panel_ManagerDevice.this, "Xóa dữ liệu thành công!");
				} else {
					ScannerUtils.showErrorMessage(Panel_ManagerDevice.this, "Xóa dữ liệu không thành công!");
				}
			}
		});
		// Bắt sự kiện khi click vào bảng và hiển thị dữ liệu dòng được chọn vào các ô input
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button.setEnabled(false);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				int selectedRow = table.getSelectedRow();
				if(selectedRow >= 0) {
					String deviceName =  table.getValueAt(selectedRow, 1).toString();
					String deviceType = table.getValueAt(selectedRow, 2).toString();
					String purchaseDate = table.getValueAt(selectedRow, 3).toString();
					String supplier = table.getValueAt(selectedRow, 4).toString();
					String price = table.getValueAt(selectedRow, 5).toString().replace(".", "").replace("VNĐ", "");
					String status = table.getValueAt(selectedRow, 6).toString();
					String roomNumber = table.getValueAt(selectedRow, 7).toString();
					String quantity = table.getValueAt(selectedRow, 8).toString();
					
					textField.setText(deviceName);
					textField_1.setText(deviceType);
					textField_2.setText(purchaseDate);
					textField_3.setText(supplier);
					textField_4.setText(price);
					textField_5.setText(quantity);
					
					for (int i = 0; i < choice_1.getItemCount(); i++) {
					    if (status.equals(choice_1.getItem(i))) {
					        choice_1.select(i);
					        break; 
					    }
					}
					
					for (int i = 0; i < comboBoxRoom.getItemCount(); i++) {
					    Room room = comboBoxRoom.getItemAt(i);
					    if (roomNumber.equals(room.getRoomNumber())) {
					        comboBoxRoom.setSelectedIndex(i);
					        break;
					    }
					}
				}
			}
		});
	}
	

	private void loadRoomData(JComboBox<Room> comboBox) {
	    controller = new ManagerDeviceController();
	    ArrayList<Room> roomList = controller.getAllRooms();
	    
	    comboBox.removeAllItems();
	    for (Room room : roomList) {
	        comboBox.addItem(room);
	    }
	}
	
	public void loadDeviceData() {
		List<Device> devices = controller.getAllDevices();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for(Device device : devices) {
        	LocalDate date = device.getPurchaseDate();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	String formatterPurchaseDate = date.format(formatter);
        	
        	String statusDisplay = device.getStatus().name();
        	
        	if(device.getStatus().name() == "AVAILABLE") {
        		statusDisplay = "CÓ SẴN";
        	} else if(device.getStatus().name() == "UNAVAILABLE") {
        		statusDisplay = "KHÔNG CÓ SẴN";
        	} else if(device.getStatus().name() == "UNDER_MAINTENANCE"){
        		statusDisplay = "ĐANG BẢO TRÌ";
        	} else if(device.getStatus().name() == "BROKEN"){
        		statusDisplay = "BỊ HỎNG";
        	} else {
        		statusDisplay = "LOẠI BỎ";
        	}
        	
        	BigDecimal price = device.getPrice();
        	NumberFormat priceFormat = NumberFormat.getNumberInstance(new Locale("vi", "VN"));
        	String formattedPrice = priceFormat.format(price) + "VNĐ";
        	
        	model.addRow(new Object[]{
                device.getId(),
                device.getDeviceName(),
                device.getDeviceType(),
                formatterPurchaseDate,
                device.getSupplier(),
                formattedPrice,
                statusDisplay,
                device.getRoom(),
                device.getQuantity()
            });
        }
	}
}
