package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import COMPONENT.RoundedButton;
import COMPONENT.RoundedPasswordField;
import COMPONENT.RoundedTextField;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;



public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private RoundedTextField roundedTextField;
	private RoundedPasswordField roundedPasswordField;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;

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
		setBounds(100, 100, 733, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(19, 41, 18));
		panel.setBounds(0, 0, 284, 480);
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
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(1, 265, 281, 41);
		panel.add(lblNewLabel_1_1);
		tabbedPane.setBounds(280, -25, 441, 506);
		contentPane.add(tabbedPane);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("Login", null, LoginPanel, null);
		LoginPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOG IN");
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
		
		roundedTextField = new RoundedTextField(8, 1);
		roundedTextField.setBackground(SystemColor.text);
		roundedTextField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		roundedTextField.setForeground(new Color(50, 48, 49));
		roundedTextField.setBounds(39, 134, 357, 42);
		LoginPanel.add(roundedTextField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password:");
		lblNewLabel_3_1.setForeground(new Color(50, 48, 49));
		lblNewLabel_3_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(36, 193, 357, 27);
		LoginPanel.add(lblNewLabel_3_1);
		
		roundedPasswordField = new RoundedPasswordField(8, 1);
		roundedPasswordField.setBackground(SystemColor.text);
		roundedPasswordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		roundedPasswordField.setBounds(39, 227, 357, 42);
		LoginPanel.add(roundedPasswordField);
		
		RoundedButton roundedButton = new RoundedButton("LOG IN WITH ADMIN RIGHT", 12, 2);
		roundedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginWithAdminRigth();
			}
		});
		roundedButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roundedButton.setHorizontalAlignment(SwingConstants.LEADING);
		roundedButton.setForeground(new Color(238, 238, 238));
		roundedButton.setVerticalAlignment(SwingConstants.TOP);
		roundedButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		roundedButton.setBackground(new Color(19, 41, 18));
		roundedButton.setBounds(39, 293, 357, 44);
		LoginPanel.add(roundedButton);
		
		RoundedButton rndbtnLogInWith = new RoundedButton("LOG IN WITH ADMIN RIGHT", 12, 2);
		rndbtnLogInWith.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rndbtnLogInWith.setText("LOG IN WITH CLIENT RIGHT");
		rndbtnLogInWith.setVerticalAlignment(SwingConstants.TOP);
		rndbtnLogInWith.setHorizontalAlignment(SwingConstants.LEADING);
		rndbtnLogInWith.setForeground(new Color(238, 238, 238));
		rndbtnLogInWith.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rndbtnLogInWith.setBackground(new Color(19, 41, 18));
		rndbtnLogInWith.setBounds(39, 347, 357, 44);
		LoginPanel.add(rndbtnLogInWith);
		
		JLabel lblNewLabel_3_2 = new JLabel("Forgot your password ?");
		lblNewLabel_3_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(new Color(50, 48, 49));
		lblNewLabel_3_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(39, 424, 357, 27);
		lblNewLabel_3_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		LoginPanel.add(lblNewLabel_3_2);
		
		JPanel ResetPassPanel = new JPanel();
		ResetPassPanel.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("ResetPass", null, ResetPassPanel, null);
		ResetPassPanel.setLayout(null);
		
		RoundedButton logOutButton = new RoundedButton("", 12, 0);
		logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOutButton.setIcon(new ImageIcon(LoginGUI.class.getResource("/icon/icons8-log-out-50.png")));
		logOutButton.setBounds(5, 425, 55, 52);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		ResetPassPanel.add(logOutButton);
	}

	protected void loginWithAdminRigth() {
		String username = roundedTextField.getText().trim();
		String password = roundedPasswordField.getText().trim();
		
		if (username.isBlank() || password.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please, Fill full the information");
			return;
		}
		
		try {
			socket = new Socket("localhost", 8000);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.println("ADMINLOGIN_"+username+"_"+password);

		try {
			String respone;
			respone = reader.readLine();
			
			if (respone != null && respone.equals("ADMIN_LOGIN_SUCCESS")) {
				JOptionPane.showMessageDialog(null, "Login successfully");
				new AdminGUI().setVisible(true);
				setVisible(false);
				return;
			} else if (respone != null && respone.equals("ADMIN_LOGIN_FAILED")) {
				JOptionPane.showMessageDialog(null, "Login failed !");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
