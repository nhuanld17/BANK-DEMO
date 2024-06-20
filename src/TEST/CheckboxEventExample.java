package TEST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckboxEventExample {

    public static void main(String[] args) {
        // Tạo frame
        JFrame frame = new JFrame("Checkbox Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Tạo JCheckBox
        JCheckBox checkBox = new JCheckBox("Payee Address");

        // Thêm ActionListener vào JCheckBox
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    System.out.println("Checkbox is selected");
                } else {
                    System.out.println("Checkbox is not selected");
                }
            }
        });

        // Thêm JCheckBox vào frame
        frame.add(checkBox);

        // Hiển thị frame
        frame.setVisible(true);
    }
}

