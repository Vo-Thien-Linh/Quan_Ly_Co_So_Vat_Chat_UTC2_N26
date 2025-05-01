package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.PermissionController;
import utils.PermissionUtils;
import utils.ScannerUtils;
import Model.Session;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PermissionView extends JPanel {

    private JTable table;
    private PermissionController permissionController = new PermissionController();
    
    public PermissionView() {
        setLayout(new BorderLayout());     
        Boolean[] rights = PermissionUtils.getRights("Phân quyền");
        
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton updateButton = new JButton("Cập nhật");
        topPanel.add(updateButton);
        add(topPanel, BorderLayout.NORTH);
        
        updateButton.setVisible(rights[2]);

        String[] columnNames = {"Chức năng", "Vai trò", "Xem", "Thêm", "Sửa", "Xóa"};
        Object[][] data = {
        	{"Quản lý phòng", "Quản trị viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Giáo viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Bảo trì", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            
            {"Quản lý thiết bị", "Quản trị viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Giáo viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Bảo trì", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            
            {"Quản lý người dùng", "Quản trị viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Giáo viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Bảo trì", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            
            {"Mượn phòng", "Quản trị viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Giáo viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Bảo trì", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            
            {"Mượn thiết bị", "Quản trị viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Giáo viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Bảo trì", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            
            {"Phân quyền", "Quản trị viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Giáo viên", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
            {"", "Bảo trì", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column >= 2) {
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 2;
            }
        };
        loadData(model);

        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        //Bắt sự kiện nút cập nhật
        updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
			        String currentFunction = "";

			        for (int i = 0; i < model.getRowCount(); i++) {
			            String functionName = (String) model.getValueAt(i, 0);
			            if (!functionName.isEmpty()) {
			                currentFunction = functionName;
			            }
			            String roleName = (String) model.getValueAt(i, 1);
			            if(roleName.equals("Bảo trì")) {
			            	roleName = "MAINTENANCE";
			            } else if(roleName.equals("Giáo viên")) {
			            	roleName = "LECTURER";
			            } else if(roleName.equals("Quản trị viên")) {
			            	roleName = "ADMIN";
			            }

			            int functionId = permissionController.getFunctionIdByName(currentFunction);
			            int roleId = permissionController.getRoleIdByName(roleName);

			            boolean view = (Boolean) model.getValueAt(i, 2);
			            boolean add = (Boolean) model.getValueAt(i, 3);
			            boolean edit = (Boolean) model.getValueAt(i, 4);
			            boolean delete = (Boolean) model.getValueAt(i, 5);

			            permissionController.updatePermission(roleId, functionId, 1, view);  
			            permissionController.updatePermission(roleId, functionId, 2, add);   
			            permissionController.updatePermission(roleId, functionId, 3, edit);  
			            permissionController.updatePermission(roleId, functionId, 4, delete);
			        }
			        
			        ScannerUtils.showSuccessMessage(PermissionView.this, "Cập nhật thành công!");
			}
		});
        
    }

    public JTable getTable() {
        return table;
    }
    
    public void loadData(DefaultTableModel model) {
    	Map<String, Boolean[]> permissions = permissionController.loadPermissionData();
        for (int i = 0; i < model.getRowCount(); i++) {
            String function = (String) model.getValueAt(i, 0);
            if (function.isEmpty()) {
                function = (String) model.getValueAt(i - 1, 0);
            }
            String role = (String) model.getValueAt(i, 1);
            String key = function + "_" + role;

            if (permissions.containsKey(key)) {
                Boolean[] rights = permissions.get(key);
                model.setValueAt(rights[0], i, 2); 
                model.setValueAt(rights[1], i, 3); 
                model.setValueAt(rights[2], i, 4); 
                model.setValueAt(rights[3], i, 5);
            }
        }
	}
}
