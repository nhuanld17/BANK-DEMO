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
	private double income;
	private double expense;
	private double transactionLimitChecking;
	private double transactionLimitSaving;

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
		
		JLabel lblNewLabel_1 = new JLabel("JRT BANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(236, 236, 236));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblNewLabel_1.setBounds(6, 93, 176, 34);
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
		panelTransactionButton.setBounds(22, 299, 143, 45);
		sidebarPanel.add(panelTransactionButton);
		
		JButton transactionButton = new JButton("Transactions");
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
		accountPanelButton.setBounds(22, 355, 143, 45);
		sidebarPanel.add(accountPanelButton);
		
		JButton accountButton = new JButton("Account");
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
		panelLoggoutButton.setBounds(22, 411, 143, 45);
		sidebarPanel.add(panelLoggoutButton);
		
		JButton btnLoggout = new JButton("Logout");
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
		tabbedPane.setBounds(187, 0, 882, 648);
		contentPane.add(tabbedPane);
		
		JPanel dashboardPanel = new JPanel();
		tabbedPane.addTab("dashboard", null, dashboardPanel, null);
		dashboardPanel.setLayout(null);
		
		JPanel transactionPanel = new JPanel();
		tabbedPane.addTab("transactionPanel", null, transactionPanel, null);
		
		JPanel account = new JPanel();
		tabbedPane.addTab("account", null, account, null);
		
		running = new AtomicBoolean(true);
		listen = new Thread(() -> {
			try {
				while (running.get() && !Thread.currentThread().isInterrupted()) {
					String message = this.reader.readLine();
					
					if (message.startsWith("DATECREATED:")) {
						dateCreated = message.substring(12);
						System.out.println(dateCreated);
					}
					
					if (message.startsWith("CHECKING_ACC_INFO:")) {
						String checkingInfo = message.substring(18);
						System.out.println(checkingInfo);
					}
					
					if (message.startsWith("SAVING_ACC_INFO:")) {
						String savingInfo = message.substring(16);
						System.out.println(savingInfo);
					}
					
					if (message.startsWith("INEX:")) {
						String INEX = message.substring(5);
						System.out.println(INEX);
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
