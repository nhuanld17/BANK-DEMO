package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import COMPONENT.RoundedButton;
import COMPONENT.RoundedPasswordField;
import COMPONENT.RoundedTextField;
import java.awt.Cursor;



public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(19, 41, 18));
		panel.setBounds(0, 0, 284, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/icon/icons8-bank-100.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 153, 281, 120);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JRT BANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(245, 255, 182));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 86, 281, 81);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Credibility and Responsibility");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(245, 255, 182));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(1, 265, 281, 41);
		panel.add(lblNewLabel_1_1);
		tabbedPane.setBounds(280, -25, 437, 468);
		contentPane.add(tabbedPane);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("Login", null, LoginPanel, null);
		LoginPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBackground(new Color(50, 48, 49));
		lblNewLabel_2.setForeground(new Color(50, 48, 49));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(17, 27, 397, 64);
		LoginPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Payee name:");
		lblNewLabel_3.setForeground(new Color(50, 48, 49));
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_3.setBounds(36, 101, 357, 27);
		LoginPanel.add(lblNewLabel_3);
		
		RoundedTextField roundedTextField = new RoundedTextField(8, 1);
		roundedTextField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		roundedTextField.setForeground(new Color(50, 48, 49));
		roundedTextField.setBounds(36, 130, 357, 42);
		LoginPanel.add(roundedTextField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password:");
		lblNewLabel_3_1.setForeground(new Color(50, 48, 49));
		lblNewLabel_3_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(36, 193, 357, 27);
		LoginPanel.add(lblNewLabel_3_1);
		
		RoundedPasswordField roundedPasswordField = new RoundedPasswordField(8, 1);
		roundedPasswordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		roundedPasswordField.setBounds(36, 223, 357, 42);
		LoginPanel.add(roundedPasswordField);
		
		RoundedButton roundedButton = new RoundedButton("LOG IN WITH ADMIN RIGHT", 12, 2);
		roundedButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roundedButton.setHorizontalAlignment(SwingConstants.LEADING);
		roundedButton.setForeground(new Color(245, 255, 182));
		roundedButton.setVerticalAlignment(SwingConstants.TOP);
		roundedButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		roundedButton.setBackground(new Color(19, 41, 18));
		roundedButton.setBounds(36, 275, 357, 44);
		LoginPanel.add(roundedButton);
		
		RoundedButton rndbtnLogInWith = new RoundedButton("LOG IN WITH ADMIN RIGHT", 12, 2);
		rndbtnLogInWith.setText("LOG IN WITH CLIENT RIGHT");
		rndbtnLogInWith.setVerticalAlignment(SwingConstants.TOP);
		rndbtnLogInWith.setHorizontalAlignment(SwingConstants.LEADING);
		rndbtnLogInWith.setForeground(new Color(245, 255, 182));
		rndbtnLogInWith.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rndbtnLogInWith.setBackground(new Color(19, 41, 18));
		rndbtnLogInWith.setBounds(37, 329, 357, 44);
		LoginPanel.add(rndbtnLogInWith);
		
		JPanel ResetPassPanel = new JPanel();
		ResetPassPanel.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("ResetPass", null, ResetPassPanel, null);
	}
}
