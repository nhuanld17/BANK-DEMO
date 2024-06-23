package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import COMPONENT.RoundedPanel;
import java.awt.Cursor;

public class ClientGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	private String payeeName;
	private JTabbedPane tabbedPane;
	private AtomicBoolean running;
	private Thread listen;
	private String clientName;
	private String dateCreated;
	private int checkingAccountNumber;
	private int savingAccountNumber;
	private double checkingAccountBalance;
	private double savingAccountBalance;
	private double income;
	private double expense;
	private double transactionLimitChecking;
	private double transactionLimitSaving;
	private JLabel currentBalanceLabel;
	private JLabel checkingDateCreatedLabel;
	private JLabel savingDateCreatedLabel;
	private JLabel checkingCardBalanceLabel;
	private JLabel savingCardBalanceLabel;
	private JLabel checkingNumberLabel;
	private JLabel savingNumberLabel;

	public ClientGUI(String payeeName, Socket socket, PrintWriter writer, BufferedReader reader) {
		this.socket = socket;
		this.writer = writer;
		this.reader = reader;
		this.payeeName = payeeName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1080, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBackground(new Color(40, 41, 33));
		sidebarPanel.setBounds(0, 0, 188, 647);
		contentPane.add(sidebarPanel);
		sidebarPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-bank-80.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 188, 96);
		sidebarPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JRTBANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(236, 236, 236));
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel_1.setBounds(6, 93, 176, 41);
		sidebarPanel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(22, 147, 143, 1);
		sidebarPanel.add(separator);
		
		RoundedPanel panelDashBoardButton = new RoundedPanel(12, 3, new Color(199, 199, 199));
		panelDashBoardButton.setLayout(null);
		panelDashBoardButton.setBackground(new Color(250, 144, 24));
		panelDashBoardButton.setBounds(22, 243, 143, 45);
		sidebarPanel.add(panelDashBoardButton);
		
		JButton dashboardButton = new JButton("Dashboard");
		dashboardButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		dashboardButton.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-dashboard-24.png")));
		dashboardButton.setForeground(SystemColor.desktop);
		dashboardButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		dashboardButton.setFocusable(false);
		dashboardButton.setBorder(null);
		dashboardButton.setBackground(new Color(250, 144, 24));
		dashboardButton.setBounds(4, 3, 134, 36);
		panelDashBoardButton.add(dashboardButton);
		
		RoundedPanel panelTransactionButton = new RoundedPanel(12, 3, new Color(199, 199, 199));
		panelTransactionButton.setLayout(null);
		panelTransactionButton.setBackground(new Color(250, 144, 24));
		panelTransactionButton.setBounds(22, 307, 143, 45);
		sidebarPanel.add(panelTransactionButton);
		
		JButton transactionButton = new JButton("Transactions");
		transactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		transactionButton.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-transaction-24.png")));
		transactionButton.setForeground(SystemColor.desktop);
		transactionButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		transactionButton.setFocusable(false);
		transactionButton.setBorder(null);
		transactionButton.setBackground(new Color(250, 144, 24));
		transactionButton.setBounds(4, 3, 134, 36);
		panelTransactionButton.add(transactionButton);
		
		RoundedPanel accountPanelButton = new RoundedPanel(12, 3, new Color(199, 199, 199));
		accountPanelButton.setLayout(null);
		accountPanelButton.setBackground(new Color(250, 144, 24));
		accountPanelButton.setBounds(22, 367, 143, 45);
		sidebarPanel.add(accountPanelButton);
		
		JButton accountButton = new JButton("Account");
		accountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		accountButton.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-account-24.png")));
		accountButton.setForeground(SystemColor.desktop);
		accountButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		accountButton.setFocusable(false);
		accountButton.setBorder(null);
		accountButton.setBackground(new Color(250, 144, 24));
		accountButton.setBounds(4, 3, 134, 36);
		accountPanelButton.add(accountButton);
		
		RoundedPanel panelLoggoutButton = new RoundedPanel(12, 3, new Color(199, 199, 199));
		panelLoggoutButton.setLayout(null);
		panelLoggoutButton.setBackground(new Color(250, 144, 24));
		panelLoggoutButton.setBounds(22, 428, 143, 45);
		sidebarPanel.add(panelLoggoutButton);
		
		JButton btnLoggout = new JButton("Logout");
		btnLoggout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLoggout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		btnLoggout.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-logout-24.png")));
		btnLoggout.setForeground(SystemColor.desktop);
		btnLoggout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLoggout.setFocusable(false);
		btnLoggout.setBorder(null);
		btnLoggout.setBackground(new Color(250, 144, 24));
		btnLoggout.setBounds(6, 3, 131, 36);
		panelLoggoutButton.add(btnLoggout);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(183, -28, 886, 676);
		contentPane.add(tabbedPane);
		
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBackground(new Color(27, 28, 29));
		tabbedPane.addTab("dashboard", null, dashboardPanel, null);
		dashboardPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Balance");
		lblNewLabel_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(26, 11, 158, 33);
		dashboardPanel.add(lblNewLabel_2);
		
		currentBalanceLabel = new JLabel("$ 10000");
		currentBalanceLabel.setForeground(SystemColor.text);
		currentBalanceLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		currentBalanceLabel.setBounds(26, 42, 182, 33);
		dashboardPanel.add(currentBalanceLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setForeground(new Color(155, 160, 164));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(440, 11, 158, 33);
		dashboardPanel.add(lblNewLabel_2_1);
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		JLabel currentDateLabel = new JLabel(currentDate.format(dateTimeFormatter));
		currentDateLabel.setForeground(SystemColor.text);
		currentDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		currentDateLabel.setBounds(440, 42, 139, 33);
		dashboardPanel.add(currentDateLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("Card");
		lblNewLabel_2_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(26, 86, 158, 33);
		dashboardPanel.add(lblNewLabel_2_2);
		
		RoundedPanel checkingCardPanel = new RoundedPanel(15, 5, new Color(88, 88, 91));
		checkingCardPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkingCardPanel.setBackground(new Color(250, 144, 25));
		checkingCardPanel.setBounds(26, 123, 297, 164);
		dashboardPanel.add(checkingCardPanel);
		checkingCardPanel.setLayout(null);
		
		checkingCardBalanceLabel = new JLabel("$ 10000");
		checkingCardBalanceLabel.setForeground(SystemColor.text);
		checkingCardBalanceLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		checkingCardBalanceLabel.setBounds(12, 9, 101, 33);
		checkingCardPanel.add(checkingCardBalanceLabel);
		
		JLabel currentBalanceLabel_1_1 = new JLabel("JRTBANK");
		currentBalanceLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalanceLabel_1_1.setForeground(SystemColor.desktop);
		currentBalanceLabel_1_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		currentBalanceLabel_1_1.setBounds(185, 4, 103, 38);
		checkingCardPanel.add(currentBalanceLabel_1_1);
		
		JLabel nameCheckingLabel = new JLabel(clientName);
		nameCheckingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameCheckingLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		nameCheckingLabel.setForeground(SystemColor.desktop);
		nameCheckingLabel.setBounds(6, 50, 252, 33);
		checkingCardPanel.add(nameCheckingLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-money-50.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 102, 62, 51);
		checkingCardPanel.add(lblNewLabel_3);
		
		checkingDateCreatedLabel = new JLabel("20/10/2005");
		checkingDateCreatedLabel.setForeground(SystemColor.window);
		checkingDateCreatedLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		checkingDateCreatedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		checkingDateCreatedLabel.setBounds(84, 85, 187, 33);
		checkingCardPanel.add(checkingDateCreatedLabel);
		
		checkingNumberLabel = new JLabel("*** ***");
		checkingNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		checkingNumberLabel.setForeground(SystemColor.window);
		checkingNumberLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		checkingNumberLabel.setBounds(84, 120, 187, 33);
		checkingCardPanel.add(checkingNumberLabel);
		
		RoundedPanel checkingCardPanel_1 = new RoundedPanel(15, 5, new Color(88, 88, 91));
		checkingCardPanel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkingCardPanel_1.setLayout(null);
		checkingCardPanel_1.setBackground(new Color(250, 144, 25));
		checkingCardPanel_1.setBounds(348, 123, 297, 164);
		dashboardPanel.add(checkingCardPanel_1);
		
		savingCardBalanceLabel = new JLabel("$ 10000");
		savingCardBalanceLabel.setForeground(SystemColor.text);
		savingCardBalanceLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		savingCardBalanceLabel.setBounds(12, 9, 101, 33);
		checkingCardPanel_1.add(savingCardBalanceLabel);
		
		JLabel currentBalanceLabel_1_1_1 = new JLabel("JRTBANK");
		currentBalanceLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalanceLabel_1_1_1.setForeground(SystemColor.desktop);
		currentBalanceLabel_1_1_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		currentBalanceLabel_1_1_1.setBounds(185, 4, 103, 38);
		checkingCardPanel_1.add(currentBalanceLabel_1_1_1);
		
		JLabel nameSavingLabel = new JLabel("Le Dinh Nhuan");
		nameSavingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameSavingLabel.setForeground(SystemColor.desktop);
		nameSavingLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		nameSavingLabel.setBounds(6, 50, 252, 33);
		checkingCardPanel_1.add(nameSavingLabel);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-greentech-50.png")));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(12, 102, 62, 51);
		checkingCardPanel_1.add(lblNewLabel_3_1);
		
		savingDateCreatedLabel = new JLabel("20/10/2005");
		savingDateCreatedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		savingDateCreatedLabel.setForeground(SystemColor.window);
		savingDateCreatedLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		savingDateCreatedLabel.setBounds(84, 85, 187, 33);
		checkingCardPanel_1.add(savingDateCreatedLabel);
		
		savingNumberLabel = new JLabel("*** ***");
		savingNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		savingNumberLabel.setForeground(SystemColor.window);
		savingNumberLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		savingNumberLabel.setBounds(84, 120, 187, 33);
		checkingCardPanel_1.add(savingNumberLabel);
		
		JPanel transactionPanel = new JPanel();
		tabbedPane.addTab("transactionPanel", null, transactionPanel, null);
		
		JPanel account = new JPanel();
		tabbedPane.addTab("account", null, account, null);
		
		running = new AtomicBoolean(true);
		listen = new Thread(() -> {
			try {
				while (running.get() && !Thread.currentThread().isInterrupted()) {
					String message = this.reader.readLine();
					
					if (message.startsWith("NAME:")) {
						this.clientName = message.substring(5);
						System.out.println(clientName);
						nameCheckingLabel.setText(this.clientName);
						nameSavingLabel.setText(this.clientName);
					}
					
					if (message.startsWith("DATECREATED:")) {
						dateCreated = message.substring(12);
						System.out.println(dateCreated);
						checkingDateCreatedLabel.setText(dateCreated);
						savingDateCreatedLabel.setText(dateCreated);
					}
					
					if (message.startsWith("CHECKING_ACC_INFO:")) {
						String checkingInfo = message.substring(18);
						System.out.println(checkingInfo);
						String[] infos = checkingInfo.split("_");
						checkingNumberLabel.setText("*** *** "+infos[0]);
						transactionLimitChecking = Double.valueOf(infos[1]);
						checkingCardBalanceLabel.setText("$ "+infos[2]);
						this.checkingAccountNumber = Integer.valueOf(infos[0]);
						this.checkingAccountBalance = Double.valueOf(infos[2]);
					}
					
					if (message.startsWith("SAVING_ACC_INFO:")) {
						String savingInfo = message.substring(16);
						System.out.println(savingInfo);
						String[] infos = savingInfo.split("_");
						savingNumberLabel.setText("*** *** "+infos[0]);
						transactionLimitSaving = Double.valueOf(infos[1]);
						savingCardBalanceLabel.setText("$ "+infos[2]);
						this.savingAccountNumber = Integer.valueOf(infos[0]);
						this.savingAccountBalance = Double.valueOf(infos[2]);
					}
					
					if (message.startsWith("INEX:")) {
						String INEX = message.substring(5);
						System.out.println(INEX);
						String[] infos = INEX.split("_");
						this.income = Double.valueOf(infos[0]);
						this.expense = Double.valueOf(infos[1]);
					}
				}
			} catch (IOException e) {
		        if (!running.get()) {
		            System.out.println("Thread is stopping because the flag was set to false.");
		        } else {
		            e.printStackTrace();
		            System.out.println("IO Exception: " + e.getMessage());
		        }
			}
		});
		listen.start();
	}

	protected void logout() {
		int respone = JOptionPane.showConfirmDialog(null, "Logout ?");
		if (respone  == JOptionPane.OK_OPTION) {
			this.writer.println("LOGOUT");
			setVisible(false);
			new LoginGUI().setVisible(true);
			running.set(false);
			listen.interrupt();
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
