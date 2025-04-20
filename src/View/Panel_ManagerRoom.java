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

public class Panel_ManagerRoom extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textField; 
    private JTextField textField_1; 
    private JTextField textField_2; 
    private JComboBox<RoomStatus> statusComboBox; // Thay textField_3 bằng JComboBox
    private JTable table;
    private RoomController controller;
    private RoomBorrowRequestRepository requestRepository;

    public Panel_ManagerRoom() {
        try {
            controller = new RoomController(this);
            requestRepository = new RoomBorrowRequestRepository();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            return;
        }

        setBackground(new Color(245, 245, 220));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Panel quản lý phòng
        JPanel roomPanel = new JPanel();
        roomPanel.setBackground(new Color(245, 245, 220));
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.X_AXIS));
        add(roomPanel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 220));
        roomPanel.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{880, 0};
        gbl_panel.rowHeights = new int[]{109, 0, 0};
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
        gbl_panel_2.columnWidths = new int[]{316, 579, 0};
        gbl_panel_2.rowHeights = new int[]{50, 50, 85, 85, 0, 0};
        gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);

        JLabel lblNewLabel = new JLabel("ID Phòng: ");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel_2.add(lblNewLabel, gbc_lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setEditable(false);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.anchor = GridBagConstraints.WEST;
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        panel_2.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Số Phòng: ");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.anchor = GridBagConstraints.WEST;
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 1;
        panel_2.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Sức chứa: ");
        lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
        gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2_1.gridx = 0;
        gbc_lblNewLabel_2_1.gridy = 2;
        panel_2.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.anchor = GridBagConstraints.WEST;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 2;
        panel_2.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Trạng thái: ");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 3;
        panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

        // Thay textField_3 bằng JComboBox
        statusComboBox = new JComboBox<>(RoomStatus.values());
        statusComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_statusComboBox = new GridBagConstraints();
        gbc_statusComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_statusComboBox.anchor = GridBagConstraints.WEST;
        gbc_statusComboBox.gridx = 1;
        gbc_statusComboBox.gridy = 3;
        panel_2.add(statusComboBox, gbc_statusComboBox);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        panel.add(scrollPane, gbc_scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID Phòng", "Số phòng", "Sức chứa", "Trạng thái"}
        ));
        scrollPane.setViewportView(table);

        // Panel nút
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 245, 220));
        roomPanel.add(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0};
        gbl_panel_1.rowHeights = new int[]{86, 85, 85, 85, 85, 0};
        gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JButton button = new JButton("Thêm");
        button.setForeground(new Color(0, 102, 0));
        button.setBackground(new Color(152, 251, 152));
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.fill = GridBagConstraints.BOTH;
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 0;
        panel_1.add(button, gbc_button);

        JButton button_1 = new JButton("Sửa");
        button_1.setForeground(new Color(255, 153, 0));
        button_1.setBackground(new Color(255, 255, 153));
        button_1.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_button_1 = new GridBagConstraints();
        gbc_button_1.fill = GridBagConstraints.BOTH;
        gbc_button_1.insets = new Insets(0, 0, 5, 0);
        gbc_button_1.gridx = 0;
        gbc_button_1.gridy = 1;
        panel_1.add(button_1, gbc_button_1);

        JButton button_2 = new JButton("Xóa");
        button_2.setForeground(new Color(204, 0, 51));
        button_2.setBackground(new Color(255, 153, 153));
        button_2.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_button_2 = new GridBagConstraints();
        gbc_button_2.fill = GridBagConstraints.BOTH;
        gbc_button_2.insets = new Insets(0, 0, 5, 0);
        gbc_button_2.gridx = 0;
        gbc_button_2.gridy = 2;
        panel_1.add(button_2, gbc_button_2);

        JButton button_3 = new JButton("Duyệt đơn mượn phòng");
        button_3.setForeground(new Color(0, 51, 153));
        button_3.setBackground(new Color(153, 204, 255));
        button_3.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_button_3 = new GridBagConstraints();
        gbc_button_3.fill = GridBagConstraints.BOTH;
        gbc_button_3.insets = new Insets(0, 0, 5, 0);
        gbc_button_3.gridx = 0;
        gbc_button_3.gridy = 3;
        panel_1.add(button_3, gbc_button_3);

        JButton button_4 = new JButton("Xuất đơn mượn");
        button_4.setForeground(new Color(255, 255, 0));
        button_4.setBackground(new Color(0, 153, 51));
        button_4.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints gbc_button_4 = new GridBagConstraints();
        gbc_button_4.fill = GridBagConstraints.BOTH;
        gbc_button_4.gridx = 0;
        gbc_button_4.gridy = 4;
        panel_1.add(button_4, gbc_button_4);

        // Load data
        refreshTable(); // Tải dữ liệu ngay khi khởi tạo

        // Table row selection (phòng)
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                textField.setText(table.getValueAt(selectedRow, 0).toString());
                textField_1.setText(table.getValueAt(selectedRow, 1).toString());
                textField_2.setText(table.getValueAt(selectedRow, 2).toString());
                statusComboBox.setSelectedItem(RoomStatus.valueOf(table.getValueAt(selectedRow, 3).toString()));
            }
        });

        // Button listeners
        button.addActionListener(e -> {
            if (validateInput()) {
                Room room = new Room(
                    "",
                    (RoomStatus) statusComboBox.getSelectedItem(),
                    textField_1.getText(),
                    Integer.parseInt(textField_2.getText())
                );
                try {
                    controller.addRoom(room);
                    clearFields();
                    refreshTable(); // Cập nhật bảng sau khi thêm
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi thêm phòng: " + ex.getMessage());
                }
            }
        });

        button_1.addActionListener(e -> {
            if (validateInput() && !textField.getText().isEmpty()) {
                Room room = new Room(
                    textField.getText(),
                    (RoomStatus) statusComboBox.getSelectedItem(),
                    textField_1.getText(),
                    Integer.parseInt(textField_2.getText())
                );
                try {
                    controller.updateRoom(room);
                    clearFields();
                    refreshTable(); // Cập nhật bảng sau khi sửa
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi sửa phòng: " + ex.getMessage());
                }
            }
        });

        button_2.addActionListener(e -> {
            if (!textField.getText().isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phòng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        controller.deleteRoom(textField.getText());
                        clearFields();
                        refreshTable(); // Cập nhật bảng sau khi xóa
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi khi xóa phòng: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một phòng để xóa.");
            }
        });

        button_3.addActionListener(e -> {
            try {
                // Tạo JDialog để hiển thị danh sách đơn mượn
                JDialog dialog = new JDialog();
                dialog.setTitle("Duyệt đơn mượn phòng");
                dialog.setSize(800, 400);
                dialog.setLocationRelativeTo(this);
                dialog.setLayout(new BorderLayout());

                // Tạo JTable cho đơn mượn
                DefaultTableModel model = new DefaultTableModel(
                    new Object[][] {},
                    new String[] {"ID Request", "Lecturer User", "Room ID", "Request Date", "Due Date", "Status"}
                );
                JTable dialogTable = new JTable(model);
                var requests = requestRepository.getPendingRequests();
                if (requests.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Chưa có đơn mượn phòng đang chờ duyệt.");
                    dialog.dispose();
                    return;
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (RoomBorrowRequest request : requests) {
                    model.addRow(new Object[]{
                        request.getIdRequest(),
                        request.getLecturerUser(),
                        request.getRoomId(),
                        dateFormat.format(request.getRequestDate()),
                        dateFormat.format(request.getDueDate()),
                        request.getBorrowingRequest().name()
                    });
                }
                JScrollPane scrollPaneDialog = new JScrollPane(dialogTable);
                dialog.add(scrollPaneDialog, BorderLayout.CENTER);

                // Panel nút Duyệt/Từ chối
                JPanel buttonPanel = new JPanel();
                JButton approveButton = new JButton("Duyệt");
                JButton rejectButton = new JButton("Từ chối");
                JButton closeButton = new JButton("Đóng");
                buttonPanel.add(approveButton);
                buttonPanel.add(rejectButton);
                buttonPanel.add(closeButton);
                dialog.add(buttonPanel, BorderLayout.SOUTH);

                // Xử lý nút Duyệt
                approveButton.addActionListener(evt -> {
                    if (dialogTable.getSelectedRow() != -1) {
                        String idRequest = dialogTable.getValueAt(dialogTable.getSelectedRow(), 0).toString();
                        String message = String.format("Duyệt đơn %s cho giảng viên %s, phòng %s?", 
                            idRequest, dialogTable.getValueAt(dialogTable.getSelectedRow(), 1), 
                            dialogTable.getValueAt(dialogTable.getSelectedRow(), 2));
                        int confirm = JOptionPane.showConfirmDialog(dialog, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            try {
                                boolean success = controller.approveBorrowRequest(idRequest, BorrowingRequestStatus.APPROVED);
                                JOptionPane.showMessageDialog(dialog, success ? "Duyệt đơn thành công!" : "Lỗi: Đơn không tồn tại.");
                                dialog.dispose();
                                refreshTable(); // Cập nhật bảng phòng
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(dialog, "Lỗi khi duyệt đơn: " + ex.getMessage());
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Vui lòng chọn một đơn mượn.");
                    }
                });

                // Xử lý nút Từ chối
                rejectButton.addActionListener(evt -> {
                    if (dialogTable.getSelectedRow() != -1) {
                        String idRequest = dialogTable.getValueAt(dialogTable.getSelectedRow(), 0).toString();
                        String message = String.format("Từ chối đơn %s cho giảng viên %s, phòng %s?", 
                            idRequest, dialogTable.getValueAt(dialogTable.getSelectedRow(), 1), 
                            dialogTable.getValueAt(dialogTable.getSelectedRow(), 2));
                        int confirm = JOptionPane.showConfirmDialog(dialog, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            try {
                                boolean success = controller.approveBorrowRequest(idRequest, BorrowingRequestStatus.REJECTED);
                                JOptionPane.showMessageDialog(dialog, success ? "Từ chối đơn thành công!" : "Lỗi: Đơn không tồn tại.");
                                dialog.dispose();
                                refreshTable(); // Cập nhật bảng phòng
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(dialog, "Lỗi khi từ chối đơn: " + ex.getMessage());
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Vui lòng chọn một đơn mượn.");
                    }
                });

                // Xử lý nút Đóng
                closeButton.addActionListener(evt -> dialog.dispose());

                dialog.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách đơn: " + ex.getMessage());
            }
        });

        // Xử lý nút Xuất đơn mượn (chưa triển khai, để lại để bạn thêm sau)
        button_4.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Chức năng xuất đơn mượn chưa được triển khai!");
        });
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
        statusComboBox.setSelectedIndex(0); // Đặt về giá trị đầu tiên (AVAILABLE)
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