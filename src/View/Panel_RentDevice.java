package View;


import Controller.RoomController;
import Model.Room;
import Model.RoomStatus;
import Model.RoomBorrowRequest;
import Model.BorrowingRequestStatus;
import Repository.RoomBorrowRequestRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import View.RoundedComponents.RoundedButton;
import View.RoundedComponents.RoundedTextField;
import utils.PermissionUtils;
public class Panel_RentDevice extends JPanel {
//    private JTable table;
    private RoomController controller;
    private RoomBorrowRequestRepository requestRepository;

//<<<<<<< HEAD
//    public Panel_ManagerRoom() {
        
//
//        setBackground(new Color(245, 245, 220));
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        // Panel quản lý phòng
//        JPanel roomPanel = new JPanel();
//        roomPanel.setBackground(new Color(245, 245, 220));
//        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.X_AXIS));
//        add(roomPanel);
//=======
	private static final long serialVersionUID = 1L;
	private RoundedTextField search;
	private RoundedTextField textField;
	private RoundedTextField textField_1;
	private RoundedTextField textField_2;
	private JTable table;
	private RoundedTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Panel_RentDevice() {
		//            controller = new RoomController(this);
		requestRepository = new RoomBorrowRequestRepository();
		setBackground(new Color(242, 242, 242));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 242, 242));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{880, 0};
		gbl_panel.rowHeights = new int[]{447, 122, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		gbl_panel_2.columnWidths = new int[]{217, 343, 302, 279};
		gbl_panel_2.rowHeights = new int[]{0, 93, 60, 60, 60, 60, 7, 60};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 4.9E-324, 0.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
        
        
        search = new RoundedTextField(10, 50);
        search.setPlaceholder("Nhập mã/Tên");
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
        
        
        JLabel lblNewLabel = new JLabel("ID Thiết bị:");
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
        
        Boolean[] rights = PermissionUtils.getRights("Quản lý phòng");
        
        RoundedButton button = new RoundedButton("Thêm", 10);
        button.setIcon(new ImageIcon(getClass().getResource("/IMG/add.png")));
        button.setHorizontalTextPosition(JButton.RIGHT); 
        button.setVerticalTextPosition(JButton.CENTER);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setForeground(new Color(4, 42, 54));
        button.setBackground(new Color(149, 227, 249));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(150, 50));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button.setBackground(new Color(19, 193, 244)); 
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button.setBackground(new Color(149, 227, 249));
		    }
		});
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(5, 5, 5, 5);
        gbc_button.gridx = 2;
        gbc_button.gridy = 2; 
        panel_2.add(button, gbc_button);
        button.setEnabled(false);
        button.setVisible(rights[1]);
        
        RoundedButton button_3 = new RoundedButton("Duyệt đơn mượn", 10);
        button_3.setText("Xác nhận mượn");
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
        gbc_button_3.insets = new Insets(5, 5, 5, 0);
        gbc_button_3.gridx = 3;
        gbc_button_3.gridy = 2; 
        panel_2.add(button_3, gbc_button_3);
		        
		        
        JLabel lblNewLabel_1 = new JLabel("Số lượng:");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_1.setForeground(new Color(4, 42, 54));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 3;
        panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textField_1 = new RoundedTextField(10, 50);
        textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.anchor = GridBagConstraints.WEST;
        gbc_textField_1.insets = new Insets(0, 0, 5, 70);
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 3;
        gbc_textField_1.weightx = 1.0;
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        panel_2.add(textField_1, gbc_textField_1);
        
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
        gbc_button_1.insets = new Insets(5, 5, 5, 5);
        gbc_button_1.gridx = 2;
        gbc_button_1.gridy = 3; 
        panel_2.add(button_1, gbc_button_1);
        button_1.setEnabled(false);
        button_1.setVisible(rights[2]);
        
        
        
        JLabel lblNewLabel_2_1 = new JLabel("Ngày mượn:");
        lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_2_1.setForeground(new Color(4, 42, 54));
        GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
        gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2_1.gridx = 0;
        gbc_lblNewLabel_2_1.gridy = 4;
        panel_2.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
        
        textField_2 = new RoundedTextField(10, 50);
        textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 70);
        gbc_textField_2.anchor = GridBagConstraints.WEST;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 4;
        gbc_textField_2.weightx = 1.0;
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
		
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
		gbc_button_2.insets = new Insets(5, 5, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 4; 
		panel_2.add(button_2, gbc_button_2);
        button_2.setEnabled(false);
		button_2.setVisible(rights[3]);
		
		RoundedButton button_4 = new RoundedButton("Xuất đơn mượn", 10);
		button_4.setIcon(new ImageIcon(getClass().getResource("/IMG/export (1).png")));
		button_4.setHorizontalTextPosition(JButton.RIGHT); 
		button_4.setVerticalTextPosition(JButton.CENTER);
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setForeground(new Color(4, 42, 54));
		button_4.setBackground(new Color(149, 227, 249));
		button_4.setFont(new Font("Arial", Font.BOLD, 20));
		button_4.setPreferredSize(new Dimension(250, 50));
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
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 4; 
		panel_2.add(button_4, gbc_button_4);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày trả:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(4, 42, 54));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new RoundedTextField(10, 50); // Cùng số cột và bán kính như textField_2
		textField_3.setText(" ");
        textField_3.setFont(new Font("Arial", Font.PLAIN, 20)); // Cùng phông chữ như textField_2
        textField_3.setColumns(10); // Cùng kích thước cột như textField_2
		
		
		JPanel listPanel = new JPanel(new BorderLayout());
        String[] columns = {
            "ID Thiết  bị", "Tên thiết bị", "Số lượng",
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

        model.addRow(new Object[]{"SP000", "demo sửa sp", "0", "0"});
        model.addRow(new Object[]{"SP01" , "Cà chua beef...", "394", "0"});
        
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

        listPanel.setBounds(30, 110, 1120, 500); 
        listPanel.add(scrollPane, BorderLayout.CENTER);
        
        GridBagConstraints gbc_listPanel = new GridBagConstraints();
        gbc_listPanel.insets = new Insets(5, 5, 5, 5);
        gbc_listPanel.fill = GridBagConstraints.BOTH;
        gbc_listPanel.gridx = 0;
        gbc_listPanel.gridy = 1; 
        panel.add(listPanel, gbc_listPanel);

        // Load data
        refreshTable(); // Tải dữ liệu ngay khi khởi tạo

        // Table row selection (phòng)
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                textField.setText(" ");
                textField_1.setText(" ");
                textField_2.setText(" ");
                panel_2.remove(textField_3);
          
             // Cấu hình GridBagConstraints cho textField_3 để khớp với textField_2
                GridBagConstraints gbc_textField_3 = new GridBagConstraints();
                gbc_textField_3.insets = new Insets(0, 0, 5, 70); // Cùng insets như textField_2
                gbc_textField_3.anchor = GridBagConstraints.WEST; // Cùng anchor như textField_2
                gbc_textField_3.gridx = 1; // Cùng gridx như textField_2
                gbc_textField_3.gridy = 5; // Vị trí dành riêng cho textField_3
                gbc_textField_3.weightx = 1.0; // Cùng weightx như textField_2
                gbc_textField_3.fill = GridBagConstraints.HORIZONTAL; // Cùng fill như textField_2
                panel_2.add(textField_3, gbc_textField_3);

                panel_2.revalidate(); // Làm mới bảng điều khiển để hiển thị thay đổi
                panel_2.repaint();
            }
        });

        // Button listeners
//        button.addActionListener(e -> {
//            if (validateInput()) {
//                //                    controller.addRoom(room);
//				                    clearFields();
//				                    refreshTable(); // Cập nhật bảng sau khi thêm
//            }
//        });

//        button_1.addActionListener(e -> {
//            if (validateInput() && !textField.getText().isEmpty()) {
//                //                    controller.updateRoom(room);
//				                    clearFields();
//				                    refreshTable(); // Cập nhật bảng sau khi sửa
//            }
//        });

//        button_2.addActionListener(e -> {
//            if (!textField.getText().isEmpty()) {
//                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phòng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
//                if (confirm == JOptionPane.YES_OPTION) {
//                    try {
//                        controller.deleteRoom(textField.getText());
//                        clearFields();
//                        refreshTable(); // Cập nhật bảng sau khi xóa
//                    } catch (SQLException ex) {
//                        JOptionPane.showMessageDialog(this, "Lỗi khi xóa phòng: " + ex.getMessage());
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Vui lòng chọn một phòng để xóa.");
//            }
//        });

//        button_3.addActionListener(e -> {
//            try {
//                // Tạo JDialog để hiển thị danh sách đơn mượn
//                JDialog dialog = new JDialog();
//                dialog.setTitle("Duyệt đơn mượn phòng");
//                dialog.setSize(800, 400);
//                dialog.setLocationRelativeTo(this);
//                dialog.getContentPane().setLayout(new BorderLayout());
//
//                // Tạo JTable cho đơn mượn
//                DefaultTableModel dialogTableModel  = new DefaultTableModel(
//                    new Object[][] {},
//                    new String[] {"ID Request", "Lecturer User", "Room ID", "Request Date", "Due Date", "Status"}
//                );
//                JTable dialogTable = new JTable(dialogTableModel);
//                var requests = requestRepository.getPendingRequests();
//                if (requests.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "Chưa có đơn mượn phòng đang chờ duyệt.");
//                    dialog.dispose();
//                    return;
//                }
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                for (RoomBorrowRequest request : requests) {
//                	dialogTableModel.addRow(new Object[]{
//                        request.getIdRequest(),
//                        request.getLecturerUser(),
//                        request.getRoomId(),
//                        dateFormat.format(request.getRequestDate()),
//                        dateFormat.format(request.getDueDate()),
//                        request.getBorrowingRequest().name()
//                    });
//                }
//                JScrollPane scrollPaneDialog = new JScrollPane(dialogTable);
//                dialog.getContentPane().add(scrollPaneDialog, BorderLayout.CENTER);
//
//                // Panel nút Duyệt/Từ chối
//                JPanel buttonPanel = new JPanel();
//                JButton approveButton = new JButton("Duyệt");
//                JButton rejectButton = new JButton("Từ chối");
//                JButton closeButton = new JButton("Đóng");
//                buttonPanel.add(approveButton);
//                buttonPanel.add(rejectButton);
//                buttonPanel.add(closeButton);
//                dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
//
//                // Xử lý nút Duyệt
//                approveButton.addActionListener(evt -> {
//                    if (dialogTable.getSelectedRow() != -1) {
//                        String idRequest = dialogTable.getValueAt(dialogTable.getSelectedRow(), 0).toString();
//                        String message = String.format("Duyệt đơn %s cho giảng viên %s, phòng %s?", 
//                            idRequest, dialogTable.getValueAt(dialogTable.getSelectedRow(), 1), 
//                            dialogTable.getValueAt(dialogTable.getSelectedRow(), 2));
//                        int confirm = JOptionPane.showConfirmDialog(dialog, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
//                        if (confirm == JOptionPane.YES_OPTION) {
//                            try {
//                                boolean success = controller.approveBorrowRequest(idRequest, BorrowingRequestStatus.APPROVED);
//                                JOptionPane.showMessageDialog(dialog, success ? "Duyệt đơn thành công!" : "Lỗi: Đơn không tồn tại.");
//                                dialog.dispose();
//                                refreshTable(); // Cập nhật bảng phòng
//                            } catch (SQLException ex) {
//                                JOptionPane.showMessageDialog(dialog, "Lỗi khi duyệt đơn: " + ex.getMessage());
//                            }
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(dialog, "Vui lòng chọn một đơn mượn.");
//                    }
//                });
//
//                // Xử lý nút Từ chối
//                rejectButton.addActionListener(evt -> {
//                    if (dialogTable.getSelectedRow() != -1) {
//                        String idRequest = dialogTable.getValueAt(dialogTable.getSelectedRow(), 0).toString();
//                        String message = String.format("Từ chối đơn %s cho giảng viên %s, phòng %s?", 
//                            idRequest, dialogTable.getValueAt(dialogTable.getSelectedRow(), 1), 
//                            dialogTable.getValueAt(dialogTable.getSelectedRow(), 2));
//                        int confirm = JOptionPane.showConfirmDialog(dialog, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
//                        if (confirm == JOptionPane.YES_OPTION) {
//                            try {
//                                boolean success = controller.approveBorrowRequest(idRequest, BorrowingRequestStatus.REJECTED);
//                                JOptionPane.showMessageDialog(dialog, success ? "Từ chối đơn thành công!" : "Lỗi: Đơn không tồn tại.");
//                                dialog.dispose();
//                                refreshTable(); // Cập nhật bảng phòng
//                            } catch (SQLException ex) {
//                                JOptionPane.showMessageDialog(dialog, "Lỗi khi từ chối đơn: " + ex.getMessage());
//                            }
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(dialog, "Vui lòng chọn một đơn mượn.");
//                    }
//                });
//
//                // Xử lý nút Đóng
//                closeButton.addActionListener(evt -> dialog.dispose());
//
//                dialog.setVisible(true);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách đơn: " + ex.getMessage());
//            }
//        });

        // Xử lý nút Xuất đơn mượn (chưa triển khai, để lại để bạn thêm sau)
//        button_4.addActionListener(e -> {
//            JOptionPane.showMessageDialog(this, "Chức năng xuất đơn mượn chưa được triển khai!");
//        });
    }

    private boolean validateInput() {
        if (textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ các trường.");
            return false;
        }
        try {
            Integer.parseInt(textField_2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sức chứa phải là một số nguyên.");
            return false;
        }
        // Không cần kiểm tra RoomStatus vì JComboBox đảm bảo giá trị hợp lệ
        return true;
    }

    private void clearFields() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
    }

    public void refreshTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (Room room : controller.getAllRooms()) {
                model.addRow(new Object[]{
                    room.getId(),
                    room.getRoomNumber(),
                    room.getSeatingCapacity(),
                    room.getStatus().name()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách phòng: " + e.getMessage());
        }
    }
}