package View;

import Controller.IncidentController;
import Model.Incident;
import Model.Session;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Panel_HandlingIncident extends JPanel {
    private static final long serialVersionUID = 1L;
    private RoundedTextField search;
    private RoundedTextField idField;
    private RoundedTextField handlingNoteField;
    private JComboBox<String> statusComboBox;
    private JTable table;
    private IncidentController controller;
    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private String currentUserId;
    private boolean isMaintenanceRole;

    public Panel_HandlingIncident() {
        currentUserId = Session.getUserId();
        String role = Session.getRole();
        isMaintenanceRole = role != null && role.equals("MAINTENANCE");
        if (currentUserId == null) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin user hiện tại. Vui lòng đăng nhập lại.");
            return;
        }
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

        search = new RoundedTextField(10, 50);
        search.setPlaceholder("Nhập ID phòng, ID thiết bị để tìm kiếm");
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

        JLabel lblIdField = new JLabel("ID Báo cáo:");
        lblIdField.setFont(new Font("Arial", Font.BOLD, 20));
        lblIdField.setForeground(new Color(4, 42, 54));
        GridBagConstraints gbc_lblIdField = new GridBagConstraints();
        gbc_lblIdField.insets = new Insets(0, 0, 5, 5);
        gbc_lblIdField.gridx = 0;
        gbc_lblIdField.gridy = 2;
        panel_2.add(lblIdField, gbc_lblIdField);

        idField = new RoundedTextField(10, 50);
        idField.setFont(new Font("Arial", Font.PLAIN, 20));
        idField.setColumns(10);
        idField.setEditable(false); 
        GridBagConstraints gbc_idField = new GridBagConstraints();
        gbc_idField.insets = new Insets(0, 0, 5, 70);
        gbc_idField.gridx = 1;
        gbc_idField.gridy = 2;
        gbc_idField.weightx = 1.0;
        gbc_idField.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(idField, gbc_idField);

        JLabel lblHandlingNote = new JLabel("Ghi chú xử lý:");
        lblHandlingNote.setFont(new Font("Arial", Font.BOLD, 20));
        lblHandlingNote.setForeground(new Color(4, 42, 54));
        lblHandlingNote.setVisible(isMaintenanceRole);
        GridBagConstraints gbc_lblHandlingNote = new GridBagConstraints();
        gbc_lblHandlingNote.insets = new Insets(0, 0, 5, 5);
        gbc_lblHandlingNote.gridx = 0;
        gbc_lblHandlingNote.gridy = 3;
        panel_2.add(lblHandlingNote, gbc_lblHandlingNote);

        handlingNoteField = new RoundedTextField(10, 50);
        handlingNoteField.setFont(new Font("Arial", Font.PLAIN, 20));
        handlingNoteField.setColumns(10);
        handlingNoteField.setVisible(isMaintenanceRole);
        GridBagConstraints gbc_handlingNoteField = new GridBagConstraints();
        gbc_handlingNoteField.insets = new Insets(0, 0, 5, 70);
        gbc_handlingNoteField.gridx = 1;
        gbc_handlingNoteField.gridy = 3;
        gbc_handlingNoteField.weightx = 1.0;
        gbc_handlingNoteField.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(handlingNoteField, gbc_handlingNoteField);

        JLabel lblStatus = new JLabel("Trạng thái:");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 20));
        lblStatus.setForeground(new Color(4, 42, 54));
        lblStatus.setVisible(isMaintenanceRole);
        
                RoundedButton handleButton = new RoundedButton("Gửi thông báo xử lý", 10);
                handleButton.setIcon(new ImageIcon(getClass().getResource("/IMG/approve.png")));
                handleButton.setHorizontalTextPosition(JButton.RIGHT);
                handleButton.setVerticalTextPosition(JButton.CENTER);
                handleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                handleButton.setForeground(new Color(4, 42, 54));
                handleButton.setBackground(new Color(149, 227, 249));
                handleButton.setFont(new Font("Arial", Font.BOLD, 18));
                handleButton.setPreferredSize(new Dimension(250, 50));
                handleButton.setVisible(isMaintenanceRole);
                handleButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        handleButton.setBackground(new Color(19, 193, 244));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        handleButton.setBackground(new Color(149, 227, 249));
                    }
                });
                GridBagConstraints gbc_handleButton = new GridBagConstraints();
                gbc_handleButton.insets = new Insets(5, 5, 5, 5);
                gbc_handleButton.gridx = 2;
                gbc_handleButton.gridy = 3;
                panel_2.add(handleButton, gbc_handleButton);
                
                        // Thêm sự kiện cho nút Gửi thông báo xử lý
                        handleButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String handlingNote = handlingNoteField.getText().trim();
                                    String idText = idField.getText().trim();
                                    String selectedStatus = (String) statusComboBox.getSelectedItem();
                                    if (handlingNote.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng nhập ghi chú xử lý.");
                                        return;
                                    }
                                    if (idText.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng chọn một sự cố từ bảng để chỉnh sửa.");
                                        return;
                                    }
                
                                    // Tìm sự cố bằng ID Báo cáo để lấy deviceId hoặc roomId
                                    Incident incident = controller.getAllIncidents().stream()
                                        .filter(inc -> inc.getIdReport().equals(idText))
                                        .findFirst()
                                        .orElse(null);
                
                                    if (incident == null) {
                                        JOptionPane.showMessageDialog(null, "Không tìm thấy sự cố với ID: " + idText);
                                        return;
                                    }
                
                                    String deviceId = incident.getDeviceId();
                                    String roomId = incident.getRoomId();
                
                                    String handledBy = currentUserId;
                                    String newDescription = handlingNote;
                                    controller.handleIncident(deviceId, roomId, newDescription, handledBy, selectedStatus);
                                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin sự cố thành công!");
                                    handlingNoteField.setText(""); 
                                    idField.setText(""); 
                                    statusComboBox.setSelectedIndex(0);
                                    refreshTable();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật thông tin sự cố: " + ex.getMessage());
                                } catch (IllegalArgumentException ex) {
                                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                                }
                            }
                        });
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 0;
        gbc_lblStatus.gridy = 4;
        panel_2.add(lblStatus, gbc_lblStatus);

        String[] statusOptions = {"IN_PROGRESS", "RESOLVED"};
        statusComboBox = new JComboBox<>(statusOptions);
        statusComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        statusComboBox.setVisible(isMaintenanceRole);
        GridBagConstraints gbc_statusComboBox = new GridBagConstraints();
        gbc_statusComboBox.insets = new Insets(0, 0, 5, 70);
        gbc_statusComboBox.gridx = 1;
        gbc_statusComboBox.gridy = 4;
        gbc_statusComboBox.weightx = 1.0;
        gbc_statusComboBox.fill = GridBagConstraints.HORIZONTAL;
        panel_2.add(statusComboBox, gbc_statusComboBox);
        
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

        // Thêm sự kiện nhấn vào bảng để hiển thị thông tin lên các trường phía trên
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isMaintenanceRole) return; 

                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String idReport = tableModel.getValueAt(selectedRow, 0).toString();
                    String description = tableModel.getValueAt(selectedRow, 4).toString();
                    String status = tableModel.getValueAt(selectedRow, 6).toString();

                    idField.setText(idReport);
                    handlingNoteField.setText(description);
                    statusComboBox.setSelectedItem(status);
                }
            }
        });

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
        refreshTable();
    }

    private void updateTable(List<Incident> incidents) {
        tableModel.setRowCount(0);
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
            tableModel.setRowCount(0);
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