package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

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
import SIDEFUNCTION.SendMailOTP;



public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private RoundedTextField roundedTextField;
	private RoundedPasswordField roundedPasswordField;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private RoundedTextField payeeTextField;
	private RoundedTextField emailTextField;
	private RoundedButton sendOTPButton;
	private RoundedTextField otpTextField;
	private RoundedButton checkOTPButton;
	private int randomOTP;
	private RoundedTextField newPasswordTextField;
	private RoundedButton updatePasswordButton;
	private String payeeName;
	private String email;

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
		lblNewLabel_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 117, 281, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Your Trust, Our Commitment");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1.setFont(new Font("Heebo", Font.BOLD, 18));
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
		lblNewLabel_3.setBounds(39, 101, 357, 27);
		LoginPanel.add(lblNewLabel_3);
		
		roundedTextField = new RoundedTextField(8, 1, Color.GRAY);
		roundedTextField.setBackground(SystemColor.text);
		roundedTextField.setBorder(new LineBorder(new Color(0,0,0), 2));
		roundedTextField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		roundedTextField.setForeground(new Color(50, 48, 49));
		roundedTextField.setBounds(39, 134, 357, 42);
		LoginPanel.add(roundedTextField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password:");
		lblNewLabel_3_1.setForeground(new Color(50, 48, 49));
		lblNewLabel_3_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(39, 193, 357, 27);
		LoginPanel.add(lblNewLabel_3_1);
		
		roundedPasswordField = new RoundedPasswordField(8, 1);
		roundedPasswordField.setBackground(SystemColor.text);
		roundedPasswordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		roundedPasswordField.setBounds(39, 227, 357, 42);
		LoginPanel.add(roundedPasswordField);
		
		RoundedButton adminLogginButton = new RoundedButton("LOG IN WITH ADMIN RIGHT", 12, 2, Color.gray);
		adminLogginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginWithAdminRigth();
			}
		});
		adminLogginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adminLogginButton.setHorizontalAlignment(SwingConstants.LEADING);
		adminLogginButton.setForeground(new Color(238, 238, 238));
		adminLogginButton.setVerticalAlignment(SwingConstants.TOP);
		adminLogginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		adminLogginButton.setBackground(new Color(19, 41, 18));
		adminLogginButton.setBounds(39, 293, 357, 44);
		LoginPanel.add(adminLogginButton);
		
		RoundedButton clientLogginButton = new RoundedButton("LOG IN WITH ADMIN RIGHT", 12, 2, Color.gray);
		clientLogginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clientLogginButton.setText("LOG IN WITH CLIENT RIGHT");
		clientLogginButton.setVerticalAlignment(SwingConstants.TOP);
		clientLogginButton.setHorizontalAlignment(SwingConstants.LEADING);
		clientLogginButton.setForeground(new Color(238, 238, 238));
		clientLogginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		clientLogginButton.setBackground(new Color(19, 41, 18));
		clientLogginButton.setBounds(39, 347, 357, 44);
		clientLogginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginWithClientRight();
			}
		});
		LoginPanel.add(clientLogginButton);
		
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
		ResetPassPanel.setForeground(SystemColor.text);
		ResetPassPanel.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("ResetPass", null, ResetPassPanel, null);
		ResetPassPanel.setLayout(null);
		
		RoundedButton logOutButton = new RoundedButton("", 12, 0, Color.gray);
		logOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOutButton.setIcon(new ImageIcon(LoginGUI.class.getResource("/icon/icons8-log-out-50.png")));
		logOutButton.setBounds(5, 425, 55, 52);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		ResetPassPanel.add(logOutButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password Recovery");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(17, 29, 34));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2_1.setBackground(new Color(50, 48, 49));
		lblNewLabel_2_1.setBounds(19, 2, 397, 60);
		ResetPassPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("Your payee name:");
		lblNewLabel_4.setForeground(new Color(17, 29, 34));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_4.setBounds(19, 74, 180, 28);
		ResetPassPanel.add(lblNewLabel_4);
		
		payeeTextField = new RoundedTextField(8, 1, Color.GRAY);
		payeeTextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		payeeTextField.setForeground(new Color(17, 29, 34));
		payeeTextField.setBounds(19, 105, 210, 40);
		ResetPassPanel.add(payeeTextField);
		
		JLabel lblNewLabel_4_1 = new JLabel("Your email:");
		lblNewLabel_4_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4_1.setForeground(new Color(17, 29, 34));
		lblNewLabel_4_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(265, 74, 161, 28);
		ResetPassPanel.add(lblNewLabel_4_1);
		
		emailTextField = new RoundedTextField(8, 1, Color.GRAY);
		emailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		emailTextField.setForeground(new Color(17, 29, 34));
		emailTextField.setBounds(265, 105, 161, 40);
		ResetPassPanel.add(emailTextField);
		
		sendOTPButton = new RoundedButton("Send OTP code", 12, 2, Color.GRAY);
		sendOTPButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sendOTPButton.setFocusable(false);
		sendOTPButton.setForeground(new Color(238, 238, 238));
		sendOTPButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		sendOTPButton.setBackground(new Color(17, 29, 34));
		sendOTPButton.setBounds(19, 155, 159, 45);
		sendOTPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendOTPCode();
			}
		});
		ResetPassPanel.add(sendOTPButton);
		
		otpTextField = new RoundedTextField(8, 1, Color.GRAY);
		otpTextField.setEditable(false);
		otpTextField.setForeground(new Color(17, 29, 34));
		otpTextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		otpTextField.setBounds(20, 235, 210, 40);
		ResetPassPanel.add(otpTextField);
		
		checkOTPButton = new RoundedButton("Send OTP code", 12, 2, Color.GRAY);
		checkOTPButton.setEnabled(false);
		checkOTPButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkOTPButton.setText("Check OTP code");
		checkOTPButton.setForeground(new Color(238, 238, 238));
		checkOTPButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		checkOTPButton.setFocusable(false);
		checkOTPButton.setBackground(new Color(17, 29, 34));
		checkOTPButton.setBounds(268, 232, 159, 45);
		checkOTPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String otp = otpTextField.getText();
				
				if (!otp.equals(randomOTP+"")) {
					JOptionPane.showMessageDialog(null, "OTP code is incorect");
					return;
				}
				
				newPasswordTextField.setEditable(true);
				updatePasswordButton.setEnabled(true);
			}
		});
		ResetPassPanel.add(checkOTPButton);
		
		JLabel lblNewLabel_4_2 = new JLabel("Enter OTP code:");
		lblNewLabel_4_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4_2.setForeground(new Color(17, 29, 34));
		lblNewLabel_4_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(19, 211, 180, 28);
		ResetPassPanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Enter new password:");
		lblNewLabel_4_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4_2_1.setForeground(new Color(17, 29, 34));
		lblNewLabel_4_2_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_4_2_1.setBounds(19, 288, 180, 28);
		ResetPassPanel.add(lblNewLabel_4_2_1);
		
		newPasswordTextField = new RoundedTextField(8, 1, Color.GRAY);
		newPasswordTextField.setEditable(false);
		newPasswordTextField.setForeground(new Color(17, 29, 34));
		newPasswordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		newPasswordTextField.setBounds(20, 312, 210, 40);
		ResetPassPanel.add(newPasswordTextField);
		
		updatePasswordButton = new RoundedButton("Send OTP code", 12, 2, Color.GRAY);
		updatePasswordButton.setEnabled(false);
		updatePasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updatePasswordButton.setText("Update");
		updatePasswordButton.setForeground(new Color(238, 238, 238));
		updatePasswordButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		updatePasswordButton.setFocusable(false);
		updatePasswordButton.setBackground(new Color(17, 29, 34));
		updatePasswordButton.setBounds(268, 309, 159, 45);
		updatePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPass = newPasswordTextField.getText().trim();
				
				if (newPass.isBlank() || newPass.length() < 8) {
					JOptionPane.showMessageDialog(null, "Password must have at least 8 character");
					return;
				}
				
				updatePassword(payeeName, newPass);
			}
		});
		ResetPassPanel.add(updatePasswordButton);

	}

	protected void loginWithClientRight() {
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
			
			writer.println("CLIENTLOGIN_"+username+"_"+password);
			
			String respone;
			respone = reader.readLine();
			
			if (respone != null && respone.equals("CLIENT_LOGIN_SUCCESS")) {
				JOptionPane.showMessageDialog(null, "Login successfully");
				new ClientGUI(username, socket, writer, reader).setVisible(true);;
				setVisible(false);
			} else if (respone != null && respone.equals("CLIENT_LOGIN_FAILED")) {
				JOptionPane.showMessageDialog(null, "Login failed !");
				return;
			} else if (respone != null && respone.equals("DUPLICATED_LOGIN") ) {
				JOptionPane.showMessageDialog(null, "This account has been already logged in");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void updatePassword(String payeeName2, String newPass) {
		try {
			this.socket = new Socket("localhost", 8000);
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.writer = new PrintWriter(socket.getOutputStream(), true);
			
			this.writer.println("UPDATEPASS:"+payeeName+"_"+newPass);
			JOptionPane.showMessageDialog(null, "Update password successfully");
			
			payeeTextField.setText(null);
			emailTextField.setText(null);
			otpTextField.setText(null);
			otpTextField.setEditable(false);
			checkOTPButton.setEnabled(false);
			newPasswordTextField.setText(null);
			newPasswordTextField.setEditable(false);
			updatePasswordButton.setEnabled(false);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.socket.close();
				this.writer.close();
				this.reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}

	protected void sendOTPCode() {
		payeeName = payeeTextField.getText().trim();
		email = emailTextField.getText().trim();
		
		if (email.isBlank() || payeeName.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please fill in all the information.");
			return;
		}
		
		if (!isValidEmailAndPayeeName(email, payeeName)) {
			JOptionPane.showMessageDialog(null, "Payeename and email is not match");
			return;
		}
		
		Random random = new Random();
		int min = 10000000;
		int max = 99999999;
		
		randomOTP = random.nextInt(max - min + 1) + min;
		
		new SendMailOTP(email, randomOTP+"");
		
		otpTextField.setEditable(true);
		checkOTPButton.setEnabled(true);
	}

	private boolean isValidEmailAndPayeeName(String email, String payeeName) {
		try {
			this.socket = new Socket("localhost", 8000);
			
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.writer = new PrintWriter(socket.getOutputStream(), true);
			
			this.writer.println("CHECK_PAYEE_MAIL:"+payeeName+"_"+email);
			String message = this.reader.readLine();
			
			if (message.equals("PAYEE_EMAIL_VALID")) {
				return true;
			} else if (message.equals("PAYEE_EMAIL_INVALID")) {
				return false;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.socket.close();
				this.writer.close();
				this.reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
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
			
			writer.println("ADMINLOGIN_"+username+"_"+password);
			
			String respone;
			respone = reader.readLine();
			
			if (respone != null && respone.equals("ADMIN_LOGIN_SUCCESS")) {
				JOptionPane.showMessageDialog(null, "Login successfully");
				new AdminGUI(username, this.socket, this.reader, this.writer).setVisible(true);
				setVisible(false);
			} else if (respone != null && respone.equals("ADMIN_LOGIN_FAILED")) {
				JOptionPane.showMessageDialog(null, "Login failed !");
				return;
			} else if (respone != null && respone.equals("DUPLICATED_LOGIN") ) {
				JOptionPane.showMessageDialog(null, "This account has been already logged in");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
