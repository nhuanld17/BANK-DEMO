package TEST;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 213, 642);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("DASHBOARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(41, 145, 125, 40);
		panel.add(btnNewButton);
		
		JButton btnCreateClient = new JButton("CREATE CLIENT");
		btnCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCreateClient.setBounds(41, 205, 126, 40);
		panel.add(btnCreateClient);
		
		JButton btnClient = new JButton("CLIENT");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnClient.setBounds(41, 267, 126, 40);
		panel.add(btnClient);
		
		JButton btnTransaction = new JButton("TRANSACTION");
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnTransaction.setBounds(40, 318, 126, 40);
		panel.add(btnTransaction);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(210, -26, 859, 671);
		contentPane.add(tabbedPane);
		
		JPanel dashboardPanel = new JPanel();
		tabbedPane.addTab("Dashboard", null, dashboardPanel, null);
		dashboardPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statictics");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 6, 205, 28);
		dashboardPanel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(127, 127, 127));
		panel_1.setBounds(11, 43, 572, 277);
		dashboardPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("28/10/2005");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(378, 6, 205, 28);
		dashboardPanel.add(lblNewLabel_1);
		
		JLabel lblLastTransaction = new JLabel("Last Transaction");
		lblLastTransaction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastTransaction.setBounds(11, 328, 205, 28);
		dashboardPanel.add(lblLastTransaction);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(11, 361, 573, 274);
		dashboardPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.desktop);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(591, 43, 2, 593);
		dashboardPanel.add(separator);
		
		JLabel lblSumarySection = new JLabel("Sumary Section");
		lblSumarySection.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumarySection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSumarySection.setBounds(626, 6, 205, 28);
		dashboardPanel.add(lblSumarySection);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(127, 127, 127));
		panel_3.setBounds(603, 43, 241, 153);
		dashboardPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total transaction");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 11, 165, 28);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("35");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 37, 165, 28);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Total transaction");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 76, 165, 28);
		panel_3.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("35");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 102, 165, 28);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblBaseInformation = new JLabel("Base Information");
		lblBaseInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBaseInformation.setBounds(626, 226, 205, 28);
		dashboardPanel.add(lblBaseInformation);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(127, 127, 127));
		panel_3_1.setBounds(603, 265, 241, 196);
		dashboardPanel.add(panel_3_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Currency:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(10, 11, 76, 28);
		panel_3_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Account 's");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(10, 67, 137, 28);
		panel_3_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("USD");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(155, 11, 76, 28);
		panel_3_1.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Transaction's limit:");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2_1.setBounds(10, 90, 137, 28);
		panel_3_1.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("10000");
		lblNewLabel_2_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2_2.setBounds(161, 85, 76, 28);
		panel_3_1.add(lblNewLabel_2_1_2_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Account 's");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setBounds(9, 136, 137, 28);
		panel_3_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("WidthDraw's limit:");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2_1_1.setBounds(9, 159, 137, 28);
		panel_3_1.add(lblNewLabel_2_1_2_1_1);
		
		JLabel lblNewLabel_2_1_2_2_1 = new JLabel("10000");
		lblNewLabel_2_1_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2_2_1.setBounds(160, 154, 76, 28);
		panel_3_1.add(lblNewLabel_2_1_2_2_1);
		
		JPanel CreateClientPanel = new JPanel();
		tabbedPane.addTab("Create Client", null, CreateClientPanel, null);
		
		JPanel ClientPanel = new JPanel();
		tabbedPane.addTab("Client", null, ClientPanel, null);
		
		JPanel TransactionPanel = new JPanel();
		tabbedPane.addTab("Transaction", null, TransactionPanel, null);
	}
}
