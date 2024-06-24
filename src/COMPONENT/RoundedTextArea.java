package COMPONENT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextArea extends JTextArea {

    private int cornerRadius;

    public RoundedTextArea(int rows, int columns, int cornerRadius) {
        super(rows, columns);
        this.cornerRadius = cornerRadius;
        setOpaque(false);
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        g2.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded JTextArea Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            RoundedTextArea textArea = new RoundedTextArea(10, 30, 20);
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
            textArea.setText("This is a JTextArea with rounded corners!");

            frame.add(new JScrollPane(textArea));
            frame.setVisible(true);
        });
    }
}

