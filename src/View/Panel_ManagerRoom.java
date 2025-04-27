package View;

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

public class Panel_ManagerRoom extends JPanel {

	private static final long serialVersionUID = 1L;
	private RoundedTextField search;
	private RoundedTextField textField;
	private RoundedTextField textField_1;
	private RoundedTextField textField_2;
	private RoundedTextField textField_3;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Panel_ManagerRoom() {
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
        gbc_search.insets = new Insets(10, 0, 5, 0);
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
        
        
        JLabel lblNewLabel = new JLabel("ID Phòng: ");
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
        
        RoundedButton button_3 = new RoundedButton("Duyệt đơn mượn", 10);
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
		        
		        
        JLabel lblNewLabel_1 = new JLabel("Số Phòng: ");
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
        
        
        
        JLabel lblNewLabel_2_1 = new JLabel("Sức chứa: ");
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
		
		JLabel lblNewLabel_2 = new JLabel("Trạng thái: ");
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
		
		JPanel listPanel = new JPanel(new BorderLayout());
        String[] columns = {
            "ID Phòng", "Số Phòng", "Sức chứa", "Trạng thái"
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
        
//		Button button_4 = new Button("Xuất đơn mượn");
//		button_4.setForeground(new Color(255, 255, 0));
//		button_4.setBackground(new Color(0, 153, 51));
//		button_4.setFont(new Font("Arial", Font.PLAIN, 20));
//		GridBagConstraints gbc_button_4 = new GridBagConstraints();
//		gbc_button_4.fill = GridBagConstraints.BOTH;
//		gbc_button_4.gridx = 0;
//		gbc_button_4.gridy = 4;
//		panel_1.add(button_4, gbc_button_4);
        
	}

}
