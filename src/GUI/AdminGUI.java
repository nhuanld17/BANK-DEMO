package GUI;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import COMPONENT.RoundedButton;
import COMPONENT.RoundedPanel;
import TEST.AdminFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class AdminGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private String payeeName;
	private JTabbedPane tabbedPane;
	private AtomicBoolean running;
	private Thread listen;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI adminGUI = new AdminGUI("Nhuan", null, null, null);
					adminGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminGUI(String payeeName, Socket socket, BufferedReader reader, PrintWriter writer) {
		this.socket = socket;
		this.reader = reader;
		this.writer = writer;
		this.payeeName = payeeName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// SIDE BAR
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBorder(null);
		sidebarPanel.setBackground(new Color(40, 41, 33));
		sidebarPanel.setBounds(0, 0, 188, 511);
		contentPane.add(sidebarPanel);
		sidebarPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AdminGUI.class.getResource("/icon/icons8-bank-80.png")));
		lblNewLabel.setBounds(4, 1, 179, 88);
		sidebarPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JRT BANK");
		lblNewLabel_1.setForeground(new Color(236, 236, 236));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 89, 176, 34);
		sidebarPanel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(22, 137, 143, 1);
		sidebarPanel.add(separator);
		
		RoundedButton dashboardButton = new RoundedButton("Dashboard", 12, 3, new Color(201, 201, 201));
		dashboardButton.setHorizontalAlignment(SwingConstants.LEFT);
		dashboardButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		dashboardButton.setText("Dashboard");
		dashboardButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashboardButton.setForeground(SystemColor.desktop);
		dashboardButton.setBackground(new Color(202, 101, 0));
		dashboardButton.setBounds(20, 177, 147, 44);
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		sidebarPanel.add(dashboardButton);
		
		RoundedButton createClientButton = new RoundedButton("Create client", 12, 3, new Color(201, 201, 201));
		createClientButton.setHorizontalAlignment(SwingConstants.LEFT);
		createClientButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createClientButton.setText("Create client");
		createClientButton.setForeground(SystemColor.desktop);
		createClientButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		createClientButton.setBackground(new Color(202, 101, 0));
		createClientButton.setBounds(20, 232, 147, 44);
		createClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		sidebarPanel.add(createClientButton);
		
		RoundedButton ClientsButton = new RoundedButton("Clients", 12, 3, new Color(201, 201, 201));
		ClientsButton.setHorizontalAlignment(SwingConstants.LEFT);
		ClientsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ClientsButton.setText("Clients");
		ClientsButton.setForeground(SystemColor.desktop);
		ClientsButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		ClientsButton.setBackground(new Color(202, 101, 0));
		ClientsButton.setBounds(20, 287, 147, 44);
		ClientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		sidebarPanel.add(ClientsButton);
		
		RoundedButton transactionButton = new RoundedButton("Transactions", 12, 3, new Color(201, 201, 201));
		transactionButton.setHorizontalAlignment(SwingConstants.LEFT);
		transactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		transactionButton.setText("Transaction");
		transactionButton.setForeground(SystemColor.desktop);
		transactionButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		transactionButton.setBackground(new Color(202, 101, 0));
		transactionButton.setBounds(20, 342, 147, 44);
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		sidebarPanel.add(transactionButton);
		
		RoundedButton LogoutButton = new RoundedButton("Logout", 12, 3, new Color(201, 201, 201));
		LogoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		LogoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LogoutButton.setText("Logout");
		LogoutButton.setForeground(SystemColor.desktop);
		LogoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		LogoutButton.setBackground(new Color(202, 101, 0));
		LogoutButton.setBounds(20, 397, 147, 44);
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}	
		});
		sidebarPanel.add(LogoutButton);
		
		// END SIDEBAR
		
		// TAB
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(183, 0, 928, 516);
		contentPane.add(tabbedPane);
		
		JPanel dashboardPanel = new JPanel();
		tabbedPane.addTab("DASHBOARD", null, dashboardPanel, null);
		
		JPanel CreateClientPanel = new JPanel();
		tabbedPane.addTab("Create Client", null, CreateClientPanel, null);
		
		JPanel ClientPanel = new JPanel();
		tabbedPane.addTab("Client", null, ClientPanel, null);
		
		JPanel Transaction = new JPanel();
		tabbedPane.addTab("Transaction", null, Transaction, null);
		
		// END TAB
		
		running = new AtomicBoolean(true);
		listen = new Thread(() -> {
			try {
				while (running.get() && !Thread.currentThread().isInterrupted()) {
					String message = this.reader.readLine();
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
	
	// Hàm được gọi khi nhấn nút loggout
	private void logout() {
		int respone = JOptionPane.showConfirmDialog(null, "Logout ???");
		if (respone == JOptionPane.OK_OPTION) {
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
