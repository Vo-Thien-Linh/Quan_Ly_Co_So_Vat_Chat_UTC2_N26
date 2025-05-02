package View;

import Controller.IncidentController;
import Model.Incident;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JPanel;
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

public class Panel_ReportIncident extends JPanel {
    private static final long serialVersionUID = 1L;
    private RoundedTextField search;
    private RoundedTextField textField;
    private RoundedTextField idField; // Trường mới để nhập ID phòng hoặc thiết bị
    private JTable table;
    private IncidentController controller;
    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private String currentUserId = "MTL0001"; // Giả định user hiện tại, thay bằng logic lấy từ session

    /**
     * Create the panel.
     */
    public Panel_ReportIncident() {
        // Khởi tạo controller
        controller = new IncidentController();

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
        search.setPlaceholder("Nhập ID phòng, ID thiết bị");
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

        // Nhãn và ô nhập Ghi chú
        JLabel lblNewLabel = new JLabel("Ghi chú:");
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
        
                // Nút Gửi ghi chú
                RoundedButton button_3 = new RoundedButton("Gửi ghi chú", 10);
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
                gbc_button_3.gridy = 2;
                panel_2.add(button_3, gbc_button_3);
                
                        // Thêm sự kiện cho nút Gửi ghi chú
                        button_3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String description = textField.getText().trim();
                                    String idText = idField.getText().trim(); // Lấy từ trường mới
                                    if (description.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng nhập ghi chú.");
                                        return;
                                    }
                                    if (idText.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng nhập ID phòng hoặc ID thiết bị.");
                                        return;
                                    }
                
                                    String deviceId = null;
                                    String roomId = null;
                                    if (idText.startsWith("D")) {
                                        deviceId = idText;
                                    } else if (idText.startsWith("R")) {
                                        roomId = idText;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ID không hợp lệ. ID phòng bắt đầu bằng 'R', ID thiết bị bắt đầu bằng 'D'.");
                                        return;
                                    }
                
                                    // Giả định người báo cáo (có thể lấy từ session, tạm hard-code)
                                    String reportedBy = "MTL0001"; // Thay bằng ID người dùng thực tế
                                    controller.reportIncident(reportedBy, deviceId, roomId, description);
                                    JOptionPane.showMessageDialog(null, "Gửi báo cáo sự cố thành công!");
                                    textField.setText(""); // Xóa ghi chú sau khi gửi
                                    idField.setText(""); // Xóa trường ID sau khi gửi
                                    refreshTable();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Lỗi khi gửi báo cáo: " + ex.getMessage());
                                } catch (IllegalArgumentException ex) {
                                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                                }
                            }
                        });

        // Nhãn và ô nhập ID Phòng/Thiết bị (trường mới)
        JLabel lblIdField = new JLabel("ID Phòng/Thiết bị:");
        lblIdField.setFont(new Font("Arial", Font.BOLD, 20));
        lblIdField.setForeground(new Color(4, 42, 54));
        GridBagConstraints gbc_lblIdField = new GridBagConstraints();
        gbc_lblIdField.insets = new Insets(0, 0, 5, 5);
        gbc_lblIdField.gridx = 0;
        gbc_lblIdField.gridy = 3;
        panel_2.add(lblIdField, gbc_lblIdField);

        idField = new RoundedTextField(10, 50);
        idField.setFont(new Font("Arial", Font.PLAIN, 20));
        idField.setColumns(10);
        idField.setPlaceholder("Nhập ID phòng hoặc ID thiết bị");
        GridBagConstraints gbc_idField = new GridBagConstraints();
        gbc_idField.insets = new Insets(0, 0, 5, 70);
        gbc_idField.gridx = 1;
        gbc_idField.gridy = 3;
        gbc_idField.weightx = 1.0;
        gbc_idField.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(idField, gbc_idField);

        // Nút Làm mới
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

        // Bảng hiển thị danh sách sự cố
        JPanel listPanel = new JPanel(new BorderLayout());
        String[] columns = {
            "ID Báo cáo", "Người báo cáo", "ID Phòng", "ID Thiết bị", "Ghi chú", "Ngày báo cáo", "Trạng thái"
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

        // Thêm sự kiện cho nút Tìm kiếm
        search_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String searchText = search.getText().trim();
                    if (searchText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập ID phòng hoặc ID thiết bị để tìm kiếm.");
                        return;
                    }
                    List<Incident> incidents;
                    if (searchText.startsWith("D")) {
                        incidents = controller.searchByDeviceId(searchText);
                    } else if (searchText.startsWith("R")) {
                        incidents = controller.searchByRoomId(searchText);
                    } else {
                        JOptionPane.showMessageDialog(null, "ID không hợp lệ. ID phòng bắt đầu bằng 'R', ID thiết bị bắt đầu bằng 'D'.");
                        return;
                    }
                    if (incidents.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy sự cố với ID: " + searchText);
                        return;
                    }
                    updateTable(incidents);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm: " + ex.getMessage());
                }
            }
        });

        // Thêm sự kiện cho nút Làm mới
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        // Load dữ liệu ban đầu
        refreshTable();
    }

    private void updateTable(List<Incident> incidents) {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        if (incidents == null || incidents.isEmpty()) {
            return;
        }
        for (Incident incident : incidents) {
            tableModel.addRow(new Object[]{
                incident.getIdReport(),
                incident.getReportedBy(),
                incident.getRoomId(),
                incident.getDeviceId(),
                incident.getDescription(),
                incident.getReportDate() != null ? dateFormat.format(incident.getReportDate()) : null,
                incident.getStatus()
            });
        }
    }

    public void refreshTable() {
        try {
            tableModel.setRowCount(0); // Xóa dữ liệu cũ
            for (Incident incident : controller.getAllIncidents()) {
                tableModel.addRow(new Object[]{
                    incident.getIdReport(),
                    incident.getReportedBy(),
                    incident.getRoomId(),
                    incident.getDeviceId(),
                    incident.getDescription(),
                    incident.getReportDate() != null ? dateFormat.format(incident.getReportDate()) : null,
                    incident.getStatus()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải danh sách sự cố: " + e.getMessage());
        }
    }
}