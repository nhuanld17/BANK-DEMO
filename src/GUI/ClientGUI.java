package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import COMPONENT.RoundedPanel;
import COMPONENT.RoundedTextField;

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
	private JLabel incomeLabel;
	private JLabel expenseLabel;
	private JLabel accountTypeNumber;
	private JLabel dateCreatedAccountTypeNumber;
	private JLabel availbleBalanceLabel;
	private JLabel transactionLimitLabel;
	private JLabel accountTypeLabel;
	private JLabel checkingCardNumberLabel;
	private JLabel transactionCheckingCardLabel;
	private JLabel dateCreatedCheckingCardLabel;
	private JLabel balanceCheckingCardLabel;
	private JLabel balanceSavingCardLabel;
	private JLabel dateCreatedSavingCardLabel;
	private JLabel transactionSavingCardLabel;
	private JLabel savingCardNumberLabel;
	private RoundedTextField funtsToCheckingTextField;
	private RoundedTextField funtsToSavingTextField;

	public ClientGUI(String payeeName, Socket socket, PrintWriter writer, BufferedReader reader) {
		setResizable(false);
		this.socket = socket;
		this.writer = writer;
		this.reader = reader;
		this.payeeName = payeeName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1090, 681);
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
		tabbedPane.setBounds(183, -28, 895, 676);
		contentPane.add(tabbedPane);
		
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBackground(new Color(27, 28, 29));
		tabbedPane.addTab("dashboard", null, dashboardPanel, null);
		dashboardPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Balance");
		lblNewLabel_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_2.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(26, 11, 158, 33);
		dashboardPanel.add(lblNewLabel_2);
		
		currentBalanceLabel = new JLabel("$ 10000");
		currentBalanceLabel.setForeground(SystemColor.text);
		currentBalanceLabel.setFont(new Font("Heebo", Font.BOLD, 20));
		currentBalanceLabel.setBounds(26, 42, 182, 33);
		dashboardPanel.add(currentBalanceLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setForeground(new Color(155, 160, 164));
		lblNewLabel_2_1.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(440, 11, 158, 33);
		dashboardPanel.add(lblNewLabel_2_1);
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		JLabel currentDateLabel = new JLabel(currentDate.format(dateTimeFormatter));
		currentDateLabel.setForeground(SystemColor.text);
		currentDateLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		currentDateLabel.setBounds(440, 42, 139, 33);
		dashboardPanel.add(currentDateLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("Card");
		lblNewLabel_2_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_2_2.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(26, 86, 158, 33);
		dashboardPanel.add(lblNewLabel_2_2);
		
		RoundedPanel checkingCardPanel = new RoundedPanel(15, 5, new Color(88, 88, 91));
		checkingCardPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkingCardPanel.setBackground(new Color(250, 144, 25));
		checkingCardPanel.setBounds(26, 123, 297, 164);
		dashboardPanel.add(checkingCardPanel);
		checkingCardPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				accountTypeLabel.setText("Checking Account");
				availbleBalanceLabel.setText("$ "+formatNumber(String.valueOf(checkingAccountBalance)));
				transactionLimitLabel.setText("$ "+ formatNumber(String.valueOf(transactionLimitChecking)));
			}
		});
		checkingCardPanel.setLayout(null);
		
		checkingCardBalanceLabel = new JLabel("$ 10000");
		checkingCardBalanceLabel.setForeground(SystemColor.text);
		checkingCardBalanceLabel.setFont(new Font("Heebo", Font.BOLD, 20));
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
		checkingCardPanel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				accountTypeLabel.setText("Saving account");
				availbleBalanceLabel.setText("$ "+formatNumber(String.valueOf(savingAccountBalance)));
				transactionLimitLabel.setText("$ "+ formatNumber(String.valueOf(transactionLimitSaving)));
			}
		});
		dashboardPanel.add(checkingCardPanel_1);
		
		savingCardBalanceLabel = new JLabel("$ 10000");
		savingCardBalanceLabel.setForeground(SystemColor.text);
		savingCardBalanceLabel.setFont(new Font("Heebo", Font.BOLD, 20));
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
		
		JLabel lblNewLabel_4 = new JLabel("Income");
		lblNewLabel_4.setForeground(new Color(155, 160, 164));
		lblNewLabel_4.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(211, 295, 68, 33);
		dashboardPanel.add(lblNewLabel_4);
		
		incomeLabel = new JLabel("$");
		incomeLabel.setForeground(new Color(11, 163, 2));
		incomeLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		incomeLabel.setBounds(289, 295, 125, 33);
		dashboardPanel.add(incomeLabel);

		expenseLabel = new JLabel("$");
		expenseLabel.setForeground(new Color(11, 163, 2));
		expenseLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		expenseLabel.setBounds(502, 295, 125, 33);
		dashboardPanel.add(expenseLabel);
		
		JLabel lblNewLabel_4_1 = new JLabel("Expense");
		lblNewLabel_4_1.setForeground(new Color(155, 160, 164));
		lblNewLabel_4_1.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(424, 295, 68, 33);
		dashboardPanel.add(lblNewLabel_4_1);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(121, 121, 121));
		separator_1.setForeground(new Color(121, 121, 121));
		separator_1.setBounds(656, 93, 1, 218);
		dashboardPanel.add(separator_1);
		
		RoundedPanel roundedPanel = new RoundedPanel(15, 0, Color.RED);
		roundedPanel.setBackground(new Color(72, 69, 68));
		roundedPanel.setBounds(666, 123, 214, 128);
		dashboardPanel.add(roundedPanel);
		roundedPanel.setLayout(null);
		
		JLabel currentBalanceLabel_1_1_1_1 = new JLabel("JRTBANK");
		currentBalanceLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalanceLabel_1_1_1_1.setForeground(new Color(236, 236, 236));
		currentBalanceLabel_1_1_1_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		currentBalanceLabel_1_1_1_1.setBounds(2, 2, 91, 38);
		roundedPanel.add(currentBalanceLabel_1_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-bank-50.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(8, 62, 74, 58);
		roundedPanel.add(lblNewLabel_5);
		
		accountTypeNumber = new JLabel("1234 5678");
		accountTypeNumber.setForeground(SystemColor.window);
		accountTypeNumber.setFont(new Font("Heebo", Font.PLAIN, 18));
		accountTypeNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		accountTypeNumber.setBounds(78, 54, 121, 29);
		roundedPanel.add(accountTypeNumber);
		
		dateCreatedAccountTypeNumber = new JLabel("1234 5678");
		dateCreatedAccountTypeNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		dateCreatedAccountTypeNumber.setForeground(SystemColor.window);
		dateCreatedAccountTypeNumber.setFont(new Font("Heebo", Font.PLAIN, 18));
		dateCreatedAccountTypeNumber.setBounds(88, 85, 121, 29);
		roundedPanel.add(dateCreatedAccountTypeNumber);
		
		JLabel lblNewLabel_6 = new JLabel("Account type");
		lblNewLabel_6.setForeground(SystemColor.window);
		lblNewLabel_6.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(666, 23, 158, 33);
		dashboardPanel.add(lblNewLabel_6);
		
		accountTypeLabel = new JLabel("Checking Account");
		accountTypeLabel.setForeground(SystemColor.window);
		accountTypeLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		accountTypeLabel.setBounds(666, 67, 158, 33);
		dashboardPanel.add(accountTypeLabel);
		
		
		JLabel lblNewLabel_7 = new JLabel("Availble");
		lblNewLabel_7.setForeground(SystemColor.window);
		lblNewLabel_7.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(667, 297, 130, 28);
		dashboardPanel.add(lblNewLabel_7);
		
		availbleBalanceLabel = new JLabel("");
		availbleBalanceLabel.setForeground(SystemColor.window);
		availbleBalanceLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		availbleBalanceLabel.setBounds(666, 321, 130, 34);
		dashboardPanel.add(availbleBalanceLabel);
		
		JLabel lblNewLabel_7_1 = new JLabel("Transaction Limit Per Day");
		lblNewLabel_7_1.setForeground(SystemColor.window);
		lblNewLabel_7_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(666, 357, 214, 34);
		dashboardPanel.add(lblNewLabel_7_1);
		
		transactionLimitLabel = new JLabel("$ <dynamic>");
		transactionLimitLabel.setForeground(SystemColor.window);
		transactionLimitLabel.setFont(new Font("Heebo", Font.PLAIN, 18));
		transactionLimitLabel.setBounds(666, 391, 130, 34);
		dashboardPanel.add(transactionLimitLabel);
		
		JLabel currentBalanceLabel_1_1_1_1_1 = new JLabel("JRTBANK");
		currentBalanceLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalanceLabel_1_1_1_1_1.setForeground(new Color(236, 236, 236));
		currentBalanceLabel_1_1_1_1_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		currentBalanceLabel_1_1_1_1_1.setBounds(729, 568, 91, 38);
		dashboardPanel.add(currentBalanceLabel_1_1_1_1_1);
		
		JLabel transactionLimitLabel_1 = new JLabel("Your Trust, Our Commitment");
		transactionLimitLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		transactionLimitLabel_1.setForeground(SystemColor.window);
		transactionLimitLabel_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		transactionLimitLabel_1.setBounds(656, 602, 233, 34);
		dashboardPanel.add(transactionLimitLabel_1);
		
		JPanel listTransactionPanel = new JPanel();
		listTransactionPanel.setBackground(new Color(80, 71, 75));
		listTransactionPanel.setBounds(26, 333, 627, 303);
		listTransactionPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(listTransactionPanel);
		scrollPane.setBorder(null);
		scrollPane.setBounds(26, 333, 627, 303);
		dashboardPanel.add(scrollPane);
		
		JLabel lblNewLabel_2_3 = new JLabel("History");
		lblNewLabel_2_3.setForeground(new Color(155, 160, 164));
		lblNewLabel_2_3.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(27, 295, 116, 33);
		dashboardPanel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Status");
		lblNewLabel_7_1_1.setForeground(new Color(155, 160, 164));
		lblNewLabel_7_1_1.setFont(new Font("Heebo", Font.BOLD, 16));
		lblNewLabel_7_1_1.setBounds(666, 426, 62, 34);
		dashboardPanel.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Active");
		lblNewLabel_7_1_1_1.setForeground(Color.RED);
		lblNewLabel_7_1_1_1.setFont(new Font("Heebo", Font.BOLD, 18));
		lblNewLabel_7_1_1_1.setBounds(794, 426, 62, 34);
		dashboardPanel.add(lblNewLabel_7_1_1_1);
		
		JLabel lblNewLabel_7_1_1_2 = new JLabel("Currency");
		lblNewLabel_7_1_1_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_7_1_1_2.setFont(new Font("Heebo", Font.BOLD, 16));
		lblNewLabel_7_1_1_2.setBounds(666, 471, 78, 34);
		dashboardPanel.add(lblNewLabel_7_1_1_2);
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("USD");
		lblNewLabel_7_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_7_1_1_1_1.setFont(new Font("Heebo", Font.BOLD, 18));
		lblNewLabel_7_1_1_1_1.setBounds(794, 471, 86, 34);
		dashboardPanel.add(lblNewLabel_7_1_1_1_1);
		
		JPanel transactionPanel = new JPanel();
		transactionPanel.setBackground(new Color(27, 28, 29));
		tabbedPane.addTab("transactionPanel", null, transactionPanel, null);
		
		JPanel account = new JPanel();
		account.setBackground(new Color(27, 28, 29));
		tabbedPane.addTab("account", null, account, null);
		account.setLayout(null);
		
		RoundedPanel accountMainPanel = new RoundedPanel(15, 0, new Color(27, 28, 29));
		accountMainPanel.setBackground(new Color(72, 70, 69));
		accountMainPanel.setForeground(new Color(72, 70, 69));
		accountMainPanel.setBounds(15, 15, 860, 617);
		account.add(accountMainPanel);
		accountMainPanel.setLayout(null);
		
		
		JLabel lblNewLabel_8 = new JLabel("Checking Account");
		lblNewLabel_8.setForeground(SystemColor.window);
		lblNewLabel_8.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(39, 18, 169, 35);
		accountMainPanel.add(lblNewLabel_8);
		
		RoundedPanel checkingCardInfoPanel = new RoundedPanel(15, 0, new Color(32, 29, 29));
		checkingCardInfoPanel.setBounds(39, 64, 417, 228);
		checkingCardInfoPanel.setBackground(new Color(32, 29, 29));
		accountMainPanel.add(checkingCardInfoPanel);
		checkingCardInfoPanel.setLayout(null);
		
		JLabel lblNewLabel_8_1 = new JLabel("Account Number");
		lblNewLabel_8_1.setForeground(SystemColor.window);
		lblNewLabel_8_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1.setBounds(33, 25, 143, 35);
		checkingCardInfoPanel.add(lblNewLabel_8_1);
		
		checkingCardNumberLabel = new JLabel("Account Number");
		checkingCardNumberLabel.setForeground(SystemColor.window);
		checkingCardNumberLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		checkingCardNumberLabel.setBounds(218, 25, 189, 35);
		checkingCardInfoPanel.add(checkingCardNumberLabel);
		
		JLabel lblNewLabel_8_1_2 = new JLabel("Transaction limit");
		lblNewLabel_8_1_2.setForeground(SystemColor.window);
		lblNewLabel_8_1_2.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_2.setBounds(33, 71, 160, 35);
		checkingCardInfoPanel.add(lblNewLabel_8_1_2);
		
		transactionCheckingCardLabel = new JLabel("Account Number");
		transactionCheckingCardLabel.setForeground(SystemColor.window);
		transactionCheckingCardLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		transactionCheckingCardLabel.setBounds(218, 71, 189, 35);
		checkingCardInfoPanel.add(transactionCheckingCardLabel);
		
		JLabel lblNewLabel_8_1_3 = new JLabel("Date Created");
		lblNewLabel_8_1_3.setForeground(SystemColor.window);
		lblNewLabel_8_1_3.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_3.setBounds(33, 117, 143, 35);
		checkingCardInfoPanel.add(lblNewLabel_8_1_3);
		
		dateCreatedCheckingCardLabel = new JLabel("Account Number");
		dateCreatedCheckingCardLabel.setForeground(SystemColor.window);
		dateCreatedCheckingCardLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		dateCreatedCheckingCardLabel.setBounds(218, 117, 189, 35);
		checkingCardInfoPanel.add(dateCreatedCheckingCardLabel);
		
		JLabel lblNewLabel_8_1_4 = new JLabel("Balance");
		lblNewLabel_8_1_4.setForeground(SystemColor.window);
		lblNewLabel_8_1_4.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_4.setBounds(33, 163, 143, 35);
		checkingCardInfoPanel.add(lblNewLabel_8_1_4);
		
		balanceCheckingCardLabel = new JLabel("Account Number");
		balanceCheckingCardLabel.setForeground(SystemColor.window);
		balanceCheckingCardLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		balanceCheckingCardLabel.setBounds(218, 163, 189, 35);
		checkingCardInfoPanel.add(balanceCheckingCardLabel);
		
		JLabel lblNewLabel_8_2 = new JLabel("Saving Account");
		lblNewLabel_8_2.setForeground(SystemColor.window);
		lblNewLabel_8_2.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_8_2.setBounds(39, 326, 169, 35);
		accountMainPanel.add(lblNewLabel_8_2);
		
		RoundedPanel savingCardInfoPanel = new RoundedPanel(15, 0, new Color(32, 29, 29));
		savingCardInfoPanel.setLayout(null);
		savingCardInfoPanel.setBackground(new Color(32, 29, 29));
		savingCardInfoPanel.setBounds(39, 372, 417, 228);
		accountMainPanel.add(savingCardInfoPanel);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Account Number");
		lblNewLabel_8_1_1.setForeground(SystemColor.window);
		lblNewLabel_8_1_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_1.setBounds(33, 25, 143, 35);
		savingCardInfoPanel.add(lblNewLabel_8_1_1);
		
		savingCardNumberLabel = new JLabel((String) null);
		savingCardNumberLabel.setForeground(SystemColor.window);
		savingCardNumberLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		savingCardNumberLabel.setBounds(218, 25, 189, 35);
		savingCardInfoPanel.add(savingCardNumberLabel);
		
		JLabel lblNewLabel_8_1_2_1 = new JLabel("Transaction limit");
		lblNewLabel_8_1_2_1.setForeground(SystemColor.window);
		lblNewLabel_8_1_2_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_2_1.setBounds(33, 71, 160, 35);
		savingCardInfoPanel.add(lblNewLabel_8_1_2_1);
		
		transactionSavingCardLabel = new JLabel((String) null);
		transactionSavingCardLabel.setForeground(SystemColor.window);
		transactionSavingCardLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		transactionSavingCardLabel.setBounds(218, 71, 189, 35);
		savingCardInfoPanel.add(transactionSavingCardLabel);
		
		JLabel lblNewLabel_8_1_3_1 = new JLabel("Date Created");
		lblNewLabel_8_1_3_1.setForeground(SystemColor.window);
		lblNewLabel_8_1_3_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_3_1.setBounds(33, 117, 143, 35);
		savingCardInfoPanel.add(lblNewLabel_8_1_3_1);
		
		dateCreatedSavingCardLabel = new JLabel("<dynamic>");
		dateCreatedSavingCardLabel.setForeground(SystemColor.window);
		dateCreatedSavingCardLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		dateCreatedSavingCardLabel.setBounds(218, 117, 189, 35);
		savingCardInfoPanel.add(dateCreatedSavingCardLabel);
		
		JLabel lblNewLabel_8_1_4_1 = new JLabel("Balance");
		lblNewLabel_8_1_4_1.setForeground(SystemColor.window);
		lblNewLabel_8_1_4_1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lblNewLabel_8_1_4_1.setBounds(33, 163, 143, 35);
		savingCardInfoPanel.add(lblNewLabel_8_1_4_1);
		
		balanceSavingCardLabel = new JLabel("$ null");
		balanceSavingCardLabel.setForeground(SystemColor.window);
		balanceSavingCardLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		balanceSavingCardLabel.setBounds(218, 163, 189, 35);
		savingCardInfoPanel.add(balanceSavingCardLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.desktop);
		separator_2.setBackground(SystemColor.desktop);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(483, 86, 1, 183);
		accountMainPanel.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setForeground(SystemColor.desktop);
		separator_2_1.setBackground(SystemColor.desktop);
		separator_2_1.setBounds(483, 398, 1, 183);
		accountMainPanel.add(separator_2_1);
		
		JLabel lblNewLabel_8_3 = new JLabel("More funts to saving account");
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3.setForeground(SystemColor.window);
		lblNewLabel_8_3.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_8_3.setBounds(516, 86, 317, 35);
		accountMainPanel.add(lblNewLabel_8_3);
		
		funtsToSavingTextField = new RoundedTextField(10, 1, new Color(70, 72, 69));
		funtsToSavingTextField.setFont(new Font("Heebo", Font.PLAIN, 18));
		funtsToSavingTextField.setBounds(562, 132, 230, 36);
		accountMainPanel.add(funtsToSavingTextField);
		
		RoundedPanel funtToSavingPanel = new RoundedPanel(8, 1, new Color(70, 72, 69));
		funtToSavingPanel.setBackground(new Color(202, 101, 0));
		funtToSavingPanel.setBounds(563, 195, 229, 35);
		accountMainPanel.add(funtToSavingPanel);
		funtToSavingPanel.setLayout(null);
		
		JButton sendFuntToSavingButton = new JButton("SEND");
		sendFuntToSavingButton.setFocusable(false);
		sendFuntToSavingButton.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-down-28.png")));
		sendFuntToSavingButton.setBackground(new Color(202, 101, 0));
		sendFuntToSavingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sendFuntToSavingButton.setBorder(null);
		sendFuntToSavingButton.setForeground(SystemColor.desktop);
		sendFuntToSavingButton.setFont(new Font("Heebo", Font.BOLD, 16));
		sendFuntToSavingButton.setBounds(3, 2, 223, 30);
		sendFuntToSavingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendFuntToSaving();
			}
		});
		funtToSavingPanel.add(sendFuntToSavingButton);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("More funts to saving account");
		lblNewLabel_8_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1.setForeground(SystemColor.window);
		lblNewLabel_8_3_1.setFont(new Font("Heebo", Font.PLAIN, 18));
		lblNewLabel_8_3_1.setBounds(516, 398, 317, 35);
		accountMainPanel.add(lblNewLabel_8_3_1);
		
		funtsToCheckingTextField = new RoundedTextField(10, 1, new Color(70, 72, 69));
		funtsToCheckingTextField.setFont(new Font("Heebo", Font.PLAIN, 18));
		funtsToCheckingTextField.setBounds(562, 444, 230, 36);
		accountMainPanel.add(funtsToCheckingTextField);
		
		RoundedPanel funtToSavingPanel_1 = new RoundedPanel(8, 1, new Color(70, 72, 69));
		funtToSavingPanel_1.setLayout(null);
		funtToSavingPanel_1.setBackground(new Color(202, 101, 0));
		funtToSavingPanel_1.setBounds(563, 504, 229, 35);
		accountMainPanel.add(funtToSavingPanel_1);
		
		JButton sendFuntToCheckingButton = new JButton("SEND");
		sendFuntToCheckingButton.setFocusable(false);
		sendFuntToCheckingButton.setIcon(new ImageIcon(ClientGUI.class.getResource("/icon/icons8-up-28.png")));
		sendFuntToCheckingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sendFuntToCheckingButton.setForeground(SystemColor.desktop);
		sendFuntToCheckingButton.setFont(new Font("Heebo", Font.BOLD, 16));
		sendFuntToCheckingButton.setBorder(null);
		sendFuntToCheckingButton.setBackground(new Color(202, 101, 0));
		sendFuntToCheckingButton.setBounds(3, 2, 223, 30);
		sendFuntToCheckingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendFundToCheckingAccount();
			}
		});
		funtToSavingPanel_1.add(sendFuntToCheckingButton);
		
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
						dateCreatedAccountTypeNumber.setText(dateCreated);
					}
					
					if (message.startsWith("CHECKING_ACC_INFO:")) {
						String checkingInfo = message.substring(18);
						System.out.println(checkingInfo);
						String[] infos = checkingInfo.split("_");
						checkingNumberLabel.setText("*** *** "+formatNumber(infos[0]));
						transactionLimitChecking = Double.valueOf(infos[1]);
						checkingCardBalanceLabel.setText("$ "+infos[2]);
						this.checkingAccountNumber = Integer.valueOf(infos[0]);
						this.checkingAccountBalance = Double.valueOf(infos[2]);
						accountTypeNumber.setText(formatNumber(infos[0]));
						availbleBalanceLabel.setText("$ "+formatNumber(infos[2]));
						transactionLimitLabel.setText("$ "+formatNumber(String.valueOf(transactionLimitChecking)));
						checkingCardNumberLabel.setText(formatNumber(String.valueOf(checkingAccountNumber)));
						transactionCheckingCardLabel.setText("$ " + transactionLimitChecking);
						dateCreatedCheckingCardLabel.setText(dateCreated);
						balanceCheckingCardLabel.setText("$ " + checkingAccountBalance);
					}
					
					if (message.startsWith("SAVING_ACC_INFO:")) {
						String savingInfo = message.substring(16);
						System.out.println(savingInfo);
						String[] infos = savingInfo.split("_");
						savingNumberLabel.setText("*** *** "+formatNumber(infos[0]));
						transactionLimitSaving = Double.valueOf(infos[1]);
						savingCardBalanceLabel.setText("$ "+infos[2]);
						this.savingAccountNumber = Integer.valueOf(infos[0]);
						this.savingAccountBalance = Double.valueOf(infos[2]);
						this.currentBalanceLabel.setText("$ "+(savingAccountBalance + checkingAccountBalance));
						savingCardNumberLabel.setText(formatNumber(String.valueOf(savingAccountNumber)));
						transactionSavingCardLabel.setText("$ "+transactionLimitSaving);
						dateCreatedSavingCardLabel.setText(dateCreated);
						balanceSavingCardLabel.setText("$ " + savingAccountBalance);
						
					}
					
					if (message.startsWith("INEX:")) {
						String INEX = message.substring(5);
						System.out.println(INEX);
						String[] infos = INEX.split("_");
						this.income = Double.valueOf(infos[0]);
						this.expense = Double.valueOf(infos[1]);
						incomeLabel.setText("$ "+this.income);
						expenseLabel.setText("$ "+this.expense);
					}
					
					if (message.startsWith("SYSTEM_TRANSFER_CHECKING:")) {
						double money = Double.valueOf(message.substring(25));
						JOptionPane.showMessageDialog(null, "Admin transfered "+ money +"$ to your checking account");
						tabbedPane.setSelectedIndex(2);
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

	protected void sendFundToCheckingAccount() {
		String fundString = funtsToCheckingTextField.getText().trim();
		
		if (fundString.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please fill amount of money in the text field");
			return;
		}
		
		double money = 0; 
		try {
			money = Double.valueOf(fundString);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Amount of money is invalid");
			return;
		}
		
		if (money <= 0) {
			JOptionPane.showMessageDialog(null, "The amount of money must be greater than 0");
			return;
		}
		
		if (money > this.savingAccountBalance || money > transactionLimitSaving) {
			JOptionPane.showMessageDialog(null, "The amount of money is not enough or greater than transaction limit");
			return;
		}
		
		this.writer.println("FUNTTOCHECKING:" + payeeName + "_" + money);
	}

	protected void sendFuntToSaving() {
		String fundString = funtsToSavingTextField.getText().trim();
		
		if (fundString.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please fill amount of money in the text field");
			return;
		}
		double money = 0; 
		try {
			money = Double.valueOf(fundString);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Amount of money is invalid");
			return;
		}
		
		if (money <= 0) {
			JOptionPane.showMessageDialog(null, "The amount of money must be greater than 0");
			return;
		}
		
		if (money > this.checkingAccountBalance) {
			JOptionPane.showMessageDialog(null, "The amount of money is not enough");
			return;
		}
		
		this.writer.println("FUNTTOSAVING:" + payeeName + "_" + money);
	}

	private String formatNumber(String number) {
		String firstPart = number.substring(0, 4);
		String secondPart = number.substring(4);
		
		return firstPart + " " + secondPart;
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
