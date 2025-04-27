package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.net.URL;

public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    protected void setValue(Object value) {
        if (value instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) value;
            setIcon(icon);
            setText(""); 
            setHorizontalAlignment(SwingConstants.CENTER);  
            setVerticalAlignment(SwingConstants.CENTER);
        } else {
            setText(value == null ? "" : value.toString());
        }
    }
}

