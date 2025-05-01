package View;

import Model.Device;
import Model.DeviceStatus;
import Repository.DeviceRepository;
import Service.LectureService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
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
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JScrollPane;

import View.RoundedComponents.RoundedButton;
import View.RoundedComponents.RoundedTextField;

public class Panel_RentDevice extends JPanel {
    private static final long serialVersionUID = 1L;
    private RoundedTextField search;
    private RoundedTextField textField;
    private RoundedTextField textField_1;
    private RoundedTextField textField_2;
    private RoundedTextField textField_3;
    private JTable table;
    private DeviceRepository deviceRepository;
    private LectureService lectureService;
    private DefaultTableModel tableModel;

    /**
     * Create the panel.
     */
    public Panel_RentDevice() {
        // Khởi tạo các đối tượng cần thiết: repository và service
        deviceRepository = new DeviceRepository();
        try {
            lectureService = new LectureService();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi khởi tạo dịch vụ: " + e.getMessage());
        }

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

        // Tạo ô tìm kiếm
        search = new RoundedTextField(10, 50);
        search.setPlaceholder("Nhập mã hoặc tên thiết bị");
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        search.setColumns(10);
        GridBagConstraints gbc_search = new GridBagConstraints();
        gbc_search.anchor = GridBagConstraints.NORTHEAST;
        gbc_search.insets = new Insets(10, 0, 5, 5);
        gbc_search.gridx = 0;
        gbc_search.gridy = 1;
        gbc_search.weightx = 1.0;
        panel_2.add(search, gbc_search);

        // Nút tìm kiếm
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

        // Nhãn và ô nhập ID Thiết bị
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

        // Nút Xác nhận mượn
        RoundedButton button_3 = new RoundedButton("Xác nhận mượn", 10);
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

        // Nhãn và ô nhập Số lượng
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

        // Nhãn và ô nhập Ngày mượn
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

        // Nút Làm mới bảng
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
        gbc_refreshButton.insets = new Insets(5, 5, 5, 0);
        gbc_refreshButton.gridx = 3;
        gbc_refreshButton.gridy = 4;
        panel_2.add(refreshButton, gbc_refreshButton);

        // Nhãn và ô nhập Ngày trả
        JLabel lblNewLabel_2 = new JLabel("Ngày trả:");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(4, 42, 54));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 5;
        panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

        textField_3 = new RoundedTextField(10, 50);
        textField_3.setFont(new Font("Arial", Font.PLAIN, 20));
        textField_3.setColumns(10);
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 70);
        gbc_textField_3.anchor = GridBagConstraints.WEST;
        gbc_textField_3.gridx = 1;
        gbc_textField_3.gridy = 5;
        gbc_textField_3.weightx = 1.0;
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(textField_3, gbc_textField_3);

        // Bảng hiển thị danh sách thiết bị
        JPanel listPanel = new JPanel(new BorderLayout());
        String[] columns = {
            "ID Thiết bị", "Tên thiết bị", "Số lượng", "Trạng thái"
        };

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

        // Load dữ liệu ban đầu vào bảng
        refreshTable();

        // Xử lý sự kiện khi chọn một hàng trong bảng
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                textField.setText(" ");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
        });

        // Xử lý nút Tìm kiếm: Tìm thiết bị theo mã hoặc tên
        search_1.addActionListener(e -> {
            searchDevices();
        });

        // Xử lý nút Xác nhận mượn: Tạo yêu cầu mượn thiết bị
        button_3.addActionListener(e -> {
            createDeviceBorrowRequest();
        });

        // Xử lý nút Làm mới: Tải lại danh sách thiết bị
        refreshButton.addActionListener(e -> {
            refreshTable();
        });
    }

    // Kiểm tra dữ liệu nhập vào có hợp lệ không
    private boolean validateInput() {
        if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || 
            textField_2.getText().isEmpty() || textField_3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ các trường.");
            return false;
        }
        try {
            int quantity = Integer.parseInt(textField_1.getText());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0.");
                return false;
            }
            // Kiểm tra số lượng yêu cầu có vượt quá số lượng hiện có không
            String deviceId = textField.getText();
            Device device = deviceRepository.getDeviceById(deviceId);
            if (device != null && quantity > device.getQuantity()) {
                JOptionPane.showMessageDialog(this, "Số lượng yêu cầu vượt quá số lượng hiện có (" + device.getQuantity() + ").");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên.");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi kiểm tra số lượng thiết bị: " + e.getMessage());
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date requestDate = dateFormat.parse(textField_2.getText());
            Date dueDate = dateFormat.parse(textField_3.getText());
            if (!dueDate.after(requestDate)) {
                JOptionPane.showMessageDialog(this, "Ngày trả phải sau ngày mượn.");
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ (yyyy-MM-dd HH:mm:ss).");
            return false;
        }
        return true;
    }

    // Xóa các trường nhập liệu sau khi thực hiện hành động
    private void clearFields() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        search.setText("");
    }

    // Tải lại dữ liệu thiết bị từ cơ sở dữ liệu và hiển thị lên bảng
    public void refreshTable() {
        try {
            tableModel.setRowCount(0); // Xóa dữ liệu cũ
            for (Device device : deviceRepository.getAllDevices()) {
                tableModel.addRow(new Object[]{
                    device.getId(),
                    device.getDeviceName(),
                    device.getQuantity(),
                    device.getStatus().toString()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách thiết bị: " + e.getMessage());
        }
    }

    // Tìm kiếm thiết bị theo mã hoặc tên
    private void searchDevices() {
        String keyword = search.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            refreshTable(); // Nếu không có từ khóa, hiển thị toàn bộ danh sách
            return;
        }

        try {
            tableModel.setRowCount(0); // Xóa dữ liệu cũ
            for (Device device : deviceRepository.getAllDevices()) {
                if (device.getId().toLowerCase().contains(keyword) || 
                    device.getDeviceName().toLowerCase().contains(keyword)) {
                    tableModel.addRow(new Object[]{
                        device.getId(),
                        device.getDeviceName(),
                        device.getQuantity(),
                        device.getStatus().toString()
                    });
                }
            }
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thiết bị phù hợp.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm thiết bị: " + e.getMessage());
        }
    }

    // Tạo yêu cầu mượn thiết bị: Gửi yêu cầu mượn thiết bị đến LectureService
    private void createDeviceBorrowRequest() {
        if (!validateInput()) {
            return;
        }

        String deviceId = textField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date requestDate = dateFormat.parse(textField_2.getText());
            Date dueDate = dateFormat.parse(textField_3.getText());

            boolean success = lectureService.borrowDevice(deviceId, requestDate, dueDate);
            if (success) {
                JOptionPane.showMessageDialog(this, "Yêu cầu mượn thiết bị đã được gửi thành công! Vui lòng chờ duyệt.");
                clearFields();
                refreshTable(); // Cập nhật bảng sau khi mượn
            } else {
                JOptionPane.showMessageDialog(this, "Không thể mượn thiết bị. Thiết bị không tồn tại, không sẵn sàng hoặc hết số lượng.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi gửi yêu cầu mượn: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
}