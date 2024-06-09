package TEST;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private int borderRadius;
    private int shadowSize;

    public RoundedButton(String text, int borderRadius, int shadowSize) {
        super(text);
        this.borderRadius = borderRadius;
        this.shadowSize = shadowSize;
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
        g2.setColor(Color.GRAY);
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Vẽ nền của button
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

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

        RoundedButton button = new RoundedButton("Rounded Button", 30, 5);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        frame.add(button);
        frame.setVisible(true);
    }
}