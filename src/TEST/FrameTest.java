package TEST;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTest frame = new FrameTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(44, 97, 157, 54);
		contentPane.add(btnNewButton);
		
		RoundedButton roundedButton = new RoundedButton("Rouned", 12, 2);
		roundedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		roundedButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roundedButton.setHorizontalAlignment(SwingConstants.LEADING);
		roundedButton.setForeground(new Color(255, 255, 255));
		roundedButton.setVerticalAlignment(SwingConstants.TOP);
		roundedButton.setBackground(new Color(19, 41, 18));
		roundedButton.setBounds(222,97, 157 ,54);
		contentPane.add(roundedButton);
		
		RoundedTextField roundedTextField = new RoundedTextField(7, 1);
		roundedTextField.setBounds(40, 170, 150, 35);
		contentPane.add(roundedTextField);
		
		
	}
}
