package View;

import javax.swing.*;
import java.awt.*;

public class RoundedComponents {

    public static class RoundedButton extends JButton {
        private int radius;

        public RoundedButton(String text, int radius) {
            super(text);
            this.radius = radius;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        public void paintBorder(Graphics g) {
        }
    }

    public static class RoundedTextField extends JTextField {
        private int radius;
        private String placeholder = "";
        
        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
            repaint();
        }

        public RoundedTextField(int radius, int columns) {
            super(columns);
            this.radius = radius;
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(getBackground());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g);
            if (getText().isEmpty()) {
                g2.setColor(Color.GRAY);
                g2.setFont(getFont().deriveFont(Font.BOLD, getFont().getSize() - 4));
                Insets insets = getInsets();
                g2.drawString(placeholder, insets.left + 5, getHeight()/2 + getFont().getSize()/2 - 4);
            }
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
            g2.dispose();
        }
    }

    // Có thể thêm RoundedPasswordField ở đây luôn nếu muốn
}
