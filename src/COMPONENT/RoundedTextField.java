package COMPONENT;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {
    private int borderRadius;
    private int shadowSize;
    
    // màu mặc định là Color.GRAY  public static final Color gray = new Color(128, 128, 128);
    public RoundedTextField(int borderRadius, int shadowSize) {
        this.borderRadius = borderRadius;
        this.shadowSize = shadowSize;
        setOpaque(false); // Làm cho nền của JTextField trong suốt
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ bóng
        g2.setColor(Color.GRAY);
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Vẽ nền của text field
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, borderRadius, borderRadius);

        // Vẽ nội dung text
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ border của text field
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

        RoundedTextField textField = new RoundedTextField(30, 5);
        textField.setPreferredSize(new Dimension(200, 40));
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);

        frame.add(textField);
        frame.setVisible(true);
    }
}

