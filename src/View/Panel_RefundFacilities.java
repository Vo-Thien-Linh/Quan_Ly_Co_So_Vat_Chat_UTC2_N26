package View;

import Controller.RefundFacilityController;
import Model.DeviceBorrowRequest;
import Model.RoomBorrowRequest;
import Model.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JScrollPane;

import View.RoundedComponents.RoundedButton;
import View.RoundedComponents.RoundedTextField;

public class Panel_RefundFacilities extends JPanel {
	private static final long serialVersionUID = 1L;
	private RoundedTextField search;
	private RoundedTextField textField;
	private RoundedTextField borrowDateField;
	private RoundedTextField returnDateField;
	private JTable table;
	private RefundFacilityController controller;
	private DefaultTableModel tableModel;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private String currentUserId;

	public Panel_RefundFacilities() {
		currentUserId = Session.getUserId();
		if (currentUserId == null) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin user hiện tại. Vui lòng đăng nhập lại.");
			return;
		}
		controller = new RefundFacilityController();

		setBackground(new Color(242, 242, 242));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 242, 242));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 880, 0 };
		gbl_panel.rowHeights = new int[] { 447, 122, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 242, 242));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 217, 343, 302, 279 };
		gbl_panel_2.rowHeights = new int[] { 0, 93, 60, 60, 60, 60, 60, 7, 60 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, 4.9E-324, 0.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		search = new RoundedTextField(10, 50);
		search.setPlaceholder("Nhập đơn mượn");
		search.setFont(new Font("Arial", Font.PLAIN, 20));
		search.setColumns(10);
		GridBagConstraints gbc_search = new GridBagConstraints();
		gbc_search.anchor = GridBagConstraints.NORTHEAST;
		gbc_search.insets = new Insets(10, 0, 5, 5);
		gbc_search.gridx = 0;
		gbc_search.gridy = 1;
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
		gbc_search_1.gridy = 1;
		panel_2.add(search_1, gbc_search_1);

		JLabel lblNewLabel = new JLabel("Đơn mượn:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		textField = new RoundedTextField(10, 50);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 70);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		gbc_textField.weightx = 1.0;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		panel_2.add(textField, gbc_textField);

		JLabel lblBorrowDate = new JLabel("Ngày mượn:");
		lblBorrowDate.setFont(new Font("Arial", Font.BOLD, 20));
		lblBorrowDate.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblBorrowDate = new GridBagConstraints();
		gbc_lblBorrowDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorrowDate.gridx = 0;
		gbc_lblBorrowDate.gridy = 3;
		panel_2.add(lblBorrowDate, gbc_lblBorrowDate);

		borrowDateField = new RoundedTextField(10, 50);
		borrowDateField.setFont(new Font("Arial", Font.PLAIN, 20));
		borrowDateField.setColumns(10);
		borrowDateField.setEditable(false); // Không cho phép chỉnh sửa ngày mượn
		GridBagConstraints gbc_borrowDateField = new GridBagConstraints();
		gbc_borrowDateField.insets = new Insets(0, 0, 5, 70);
		gbc_borrowDateField.gridx = 1;
		gbc_borrowDateField.gridy = 3;
		gbc_borrowDateField.weightx = 1.0;
		gbc_borrowDateField.fill = GridBagConstraints.HORIZONTAL;
		panel_2.add(borrowDateField, gbc_borrowDateField);

		RoundedButton button_3 = new RoundedButton("Xác nhận trả", 10);
		button_3.setIcon(new ImageIcon(getClass().getResource("/IMG/approve.png")));
		button_3.setHorizontalTextPosition(JButton.RIGHT);
		button_3.setVerticalTextPosition(JButton.CENTER);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setForeground(new Color(4, 42, 54));
		button_3.setBackground(new Color(149, 227, 249));
		button_3.setFont(new Font("Arial", Font.BOLD, 20));
		button_3.setPreferredSize(new Dimension(250, 50));
		button_3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button_3.setBackground(new Color(19, 193, 244));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button_3.setBackground(new Color(149, 227, 249));
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(5, 5, 5, 5);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 3;
		panel_2.add(button_3, gbc_button_3);

		// Thêm sự kiện cho nút Xác nhận trả
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String idRequest = textField.getText().trim();
					if (idRequest.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập ID đơn mượn.");
						return;
					}

					controller.refundFacility(idRequest, currentUserId);
					JOptionPane.showMessageDialog(null, "Trả đơn mượn thành công!");
					textField.setText("");
					borrowDateField.setText("");
					returnDateField.setText("");
					refreshTable();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
				}
			}
		});

		JLabel lblReturnDate = new JLabel("Ngày trả:");
		lblReturnDate.setFont(new Font("Arial", Font.BOLD, 20));
		lblReturnDate.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblReturnDate = new GridBagConstraints();
		gbc_lblReturnDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblReturnDate.gridx = 0;
		gbc_lblReturnDate.gridy = 4;
		panel_2.add(lblReturnDate, gbc_lblReturnDate);

		returnDateField = new RoundedTextField(10, 50);
		returnDateField.setFont(new Font("Arial", Font.PLAIN, 20));
		returnDateField.setColumns(10);
		returnDateField.setEditable(false);
		GridBagConstraints gbc_returnDateField = new GridBagConstraints();
		gbc_returnDateField.insets = new Insets(0, 0, 5, 70);
		gbc_returnDateField.gridx = 1;
		gbc_returnDateField.gridy = 4;
		gbc_returnDateField.weightx = 1.0;
		gbc_returnDateField.fill = GridBagConstraints.HORIZONTAL;
		panel_2.add(returnDateField, gbc_returnDateField);

		RoundedButton refreshButton = new RoundedButton("Làm mới", 10);
		refreshButton.setIcon(new ImageIcon(getClass().getResource("/IMG/refresh.png")));
		refreshButton.setHorizontalTextPosition(JButton.RIGHT);
		refreshButton.setVerticalTextPosition(JButton.CENTER);
		refreshButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refreshButton.setForeground(new Color(4, 42, 54));
		refreshButton.setBackground(new Color(149, 227, 249));
		refreshButton.setFont(new Font("Arial", Font.BOLD, 20));
		refreshButton.setPreferredSize(new Dimension(250, 50));
		refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				refreshButton.setBackground(new Color(19, 193, 244));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				refreshButton.setBackground(new Color(149, 227, 249));
			}
		});
		GridBagConstraints gbc_refreshButton = new GridBagConstraints();
		gbc_refreshButton.insets = new Insets(5, 5, 5, 5);
		gbc_refreshButton.gridx = 2;
		gbc_refreshButton.gridy = 4;
		panel_2.add(refreshButton, gbc_refreshButton);

		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});

		JPanel listPanel = new JPanel(new BorderLayout());
		String[] columns = { "Loại đơn mượn", "ID đơn mượn", "Người mượn", "ID Phòng", "ID Thiết bị", "Thời gian mượn",
				"Thời gian trả", "Trạng thái đơn mượn" };

		tableModel = new DefaultTableModel(null, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			public Class<?> getColumnClass(int column) {
				return String.class;
			}
		};

		table = new JTable(tableModel);
		table.setRowHeight(50);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(false);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setFocusable(false);
		table.setForeground(new Color(6, 46, 75));

		// Thêm sự kiện nhấn vào bảng để hiển thị thông tin lên các trường phía trên
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String idRequest = tableModel.getValueAt(selectedRow, 1).toString();
					String borrowDate = tableModel.getValueAt(selectedRow, 5) != null
							? tableModel.getValueAt(selectedRow, 5).toString()
							: "";
					String returnDate = tableModel.getValueAt(selectedRow, 6) != null
							? tableModel.getValueAt(selectedRow, 6).toString()
							: "";

					textField.setText(idRequest);
					borrowDateField.setText(borrowDate);
					returnDateField.setText(returnDate);
				}
			}
		});

		DefaultTableCellRenderer noFocusRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

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
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
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

		listPanel.setBounds(30, 110, 1120, 500);
		listPanel.add(scrollPane, BorderLayout.CENTER);

		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.insets = new Insets(5, 5, 5, 5);
		gbc_listPanel.fill = GridBagConstraints.BOTH;
		gbc_listPanel.gridx = 0;
		gbc_listPanel.gridy = 1;
		panel.add(listPanel, gbc_listPanel);

		// Thêm sự kiện cho nút Tìm kiếm
		search_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String searchText = search.getText().trim();
					if (searchText.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập ID đơn mượn để tìm kiếm.");
						return;
					}
					List<DeviceBorrowRequest> deviceRequests = controller.searchDeviceByRequestId(searchText);
					List<RoomBorrowRequest> roomRequests = controller.searchRoomByRequestId(searchText);
					tableModel.setRowCount(0);
					if (!deviceRequests.isEmpty()) {
						for (DeviceBorrowRequest request : deviceRequests) {
							if (request.getLecturerUser().equals(currentUserId)) {
								tableModel.addRow(new Object[] { "Thiết bị", request.getIdRequest(),
										request.getLecturerUser(), null, request.getDeviceId(),
										request.getRequestDate() != null ? dateFormat.format(request.getRequestDate())
												: null,
										request.getDueDate() != null ? dateFormat.format(request.getDueDate()) : null,
										request.getBorrowingRequest() });
							}
						}
					}
					if (!roomRequests.isEmpty()) {
						for (RoomBorrowRequest request : roomRequests) {
							if (request.getLecturerUser().equals(currentUserId)) {
								tableModel.addRow(new Object[] { "Phòng", request.getIdRequest(),
										request.getLecturerUser(), request.getRoomId(), null,
										request.getRequestDate() != null ? dateFormat.format(request.getRequestDate())
												: null,
										request.getDueDate() != null ? dateFormat.format(request.getDueDate()) : null,
										request.getBorrowingRequest() });
							}
						}
					}
					if (tableModel.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn mượn với ID: " + searchText);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
				}
			}
		});
		refreshTable();
	}

	public void refreshTable() {
		try {
			tableModel.setRowCount(0);
			List<Object> allRequests = controller.getRequestsByUser(currentUserId);
			for (Object request : allRequests) {
				if (request instanceof DeviceBorrowRequest) {
					DeviceBorrowRequest deviceRequest = (DeviceBorrowRequest) request;
					tableModel.addRow(new Object[] { "Thiết bị", deviceRequest.getIdRequest(),
							deviceRequest.getLecturerUser(), null, deviceRequest.getDeviceId(),
							deviceRequest.getRequestDate() != null ? dateFormat.format(deviceRequest.getRequestDate())
									: null,
							deviceRequest.getDueDate() != null ? dateFormat.format(deviceRequest.getDueDate()) : null,
							deviceRequest.getBorrowingRequest() });
				} else if (request instanceof RoomBorrowRequest) {
					RoomBorrowRequest roomRequest = (RoomBorrowRequest) request;
					tableModel.addRow(new Object[] { "Phòng", roomRequest.getIdRequest(), roomRequest.getLecturerUser(),
							roomRequest.getRoomId(), null,
							roomRequest.getRequestDate() != null ? dateFormat.format(roomRequest.getRequestDate())
									: null,
							roomRequest.getDueDate() != null ? dateFormat.format(roomRequest.getDueDate()) : null,
							roomRequest.getBorrowingRequest() });
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
		}
	}

	public void updateTable() {
		refreshTable();
	}
}