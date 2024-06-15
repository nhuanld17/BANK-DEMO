package COMPONENT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class RoundedButton extends JButton {
    private int borderRadius;
    private int shadowSize;
    private Color color;

    public RoundedButton(String text, int borderRadius, int shadowSize, Color color) {
        super(text);
        this.borderRadius = borderRadius;
        this.shadowSize = shadowSize;
        this.color = color;
        setOpaque(false); // Làm cho nền của JButton trong suốt
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ bóng
        g2.setColor(color);
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Vẽ nền của button
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);
        
        // Vẽ icon nếu có
        Icon icon = getIcon();
        if (icon != null) {
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int iconX = (getWidth() - iconWidth) / 2;
            int iconY = (getHeight() - iconHeight) / 2;
            icon.paintIcon(this, g2, iconX, iconY);
        }

        // Vẽ text của button
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int stringWidth = fm.stringWidth(getText());
        int stringHeight = fm.getAscent();
        g2.drawString(getText(), (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - fm.getDescent());

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width = size.width + shadowSize;
        size.height = size.height + shadowSize;
        return size;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());

        RoundedButton button = new RoundedButton("Rounded Button", 30, 5, Color.gray);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        frame.add(button);
        frame.setVisible(true);
    }
}