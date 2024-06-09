package COMPONENT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class RoundedPasswordField extends JPasswordField {
    private int borderRadius;
    private int shadowSize;

    public RoundedPasswordField(int borderRadius, int shadowSize) {
        this.borderRadius = borderRadius;
        this.shadowSize = shadowSize;
        setOpaque(false); // Làm cho nền của JPasswordField trong suốt
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ bóng
        g2.setColor(Color.GRAY);
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Vẽ nền của password field
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Vẽ nội dung password
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ border của password field
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        return new Insets(shadowSize, shadowSize, shadowSize, shadowSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        RoundedPasswordField passwordField = new RoundedPasswordField(30, 5);
        passwordField.setPreferredSize(new Dimension(200, 40));
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.BLACK);

        frame.add(passwordField);
        frame.setVisible(true);
    }
}
