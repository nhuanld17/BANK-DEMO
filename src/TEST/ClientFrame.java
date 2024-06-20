package TEST;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(40, 41, 33));
		panel.setBounds(0, -1, 173, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(27, 28, 29));
		panel_1.setBounds(173, 0, 891, 589);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 144, 25));
		panel_2.setBounds(17, 97, 276, 158);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("$ 1000000");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 115, 23);
		panel_2.add(lblNewLabel);
		
		JLabel lblJrtBank = new JLabel("JRT BANK");
		lblJrtBank.setForeground(SystemColor.desktop);
		lblJrtBank.setFont(new Font("Courier New", Font.BOLD, 20));
		lblJrtBank.setBounds(135, 11, 115, 23);
		panel_2.add(lblJrtBank);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ClientFrame.class.getResource("/icon/icons8-money-50.png")));
		lblNewLabel_4.setBounds(10, 71, 94, 76);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblJrtBank_1_1_1_1_1 = new JLabel("Lê Đình Nhuận");
		lblJrtBank_1_1_1_1_1.setForeground(SystemColor.desktop);
		lblJrtBank_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJrtBank_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_1.setBounds(72, 48, 161, 23);
		panel_2.add(lblJrtBank_1_1_1_1_1);
		
		JLabel lblJrtBank_1_1_1_1_3 = new JLabel("28/10/2005");
		lblJrtBank_1_1_1_1_3.setForeground(SystemColor.text);
		lblJrtBank_1_1_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_3.setBounds(136, 86, 114, 23);
		panel_2.add(lblJrtBank_1_1_1_1_3);
		
		JLabel lblJrtBank_1_1_1_1_4 = new JLabel("*** ***  1234 5678");
		lblJrtBank_1_1_1_1_4.setForeground(SystemColor.text);
		lblJrtBank_1_1_1_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_4.setBounds(74, 124, 182, 23);
		panel_2.add(lblJrtBank_1_1_1_1_4);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(611, 99, 2, 132);
		panel_1.add(separator);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(180, 82, 2), 3));
		panel_3.setBackground(new Color(27, 28, 29));
		panel_3.setBounds(630, 99, 250, 118);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblJrtBank_1_1 = new JLabel("JRT BANK");
		lblJrtBank_1_1.setBackground(new Color(155, 160, 164));
		lblJrtBank_1_1.setForeground(new Color(155, 160, 164));
		lblJrtBank_1_1.setBounds(10, 11, 96, 23);
		lblJrtBank_1_1.setFont(new Font("Courier New", Font.BOLD, 20));
		panel_3.add(lblJrtBank_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ClientFrame.class.getResource("/icon/icons8-bank-100.png")));
		lblNewLabel_3.setBounds(10, 45, 96, 61);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblJrtBank_1_1_1 = new JLabel("1234 5678");
		lblJrtBank_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1.setForeground(Color.WHITE);
		lblJrtBank_1_1_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_1.setBounds(127, 45, 110, 23);
		panel_3.add(lblJrtBank_1_1_1);
		
		JLabel lblJrtBank_1_1_1_1 = new JLabel("28/10/2005");
		lblJrtBank_1_1_1_1.setForeground(Color.WHITE);
		lblJrtBank_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1.setBounds(125, 81, 114, 23);
		panel_3.add(lblJrtBank_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Total balance");
		lblNewLabel_1.setForeground(new Color(155, 160, 164));
		lblNewLabel_1.setBackground(new Color(155, 160, 164));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(18, 2, 189, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cards");
		lblNewLabel_1_1.setForeground(new Color(155, 160, 164));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(19, 66, 189, 24);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(250, 144, 25));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(322, 97, 276, 158);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("$ 1000000");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 11, 115, 23);
		panel_2_1.add(lblNewLabel_2);
		
		JLabel lblJrtBank_1 = new JLabel("JRT BANK");
		lblJrtBank_1.setForeground(SystemColor.desktop);
		lblJrtBank_1.setFont(new Font("Courier New", Font.BOLD, 20));
		lblJrtBank_1.setBounds(135, 11, 115, 23);
		panel_2_1.add(lblJrtBank_1);
		
		JLabel lblJrtBank_1_1_1_1_1_1 = new JLabel("Lê Đình Nhuận");
		lblJrtBank_1_1_1_1_1_1.setForeground(SystemColor.desktop);
		lblJrtBank_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJrtBank_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_1_1.setBounds(72, 45, 161, 23);
		panel_2_1.add(lblJrtBank_1_1_1_1_1_1);
		
		JLabel lblJrtBank_1_1_1_1_2 = new JLabel("28/10/2005");
		lblJrtBank_1_1_1_1_2.setForeground(SystemColor.text);
		lblJrtBank_1_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_2.setBounds(135, 79, 114, 23);
		panel_2_1.add(lblJrtBank_1_1_1_1_2);
		
		JLabel lblJrtBank_1_1_1_1_4_1 = new JLabel("*** ***  1234 5678");
		lblJrtBank_1_1_1_1_4_1.setForeground(SystemColor.text);
		lblJrtBank_1_1_1_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_4_1.setBounds(71, 122, 182, 23);
		panel_2_1.add(lblJrtBank_1_1_1_1_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(ClientFrame.class.getResource("/icon/icons8-money-50.png")));
		lblNewLabel_4_1.setBounds(6, 77, 94, 76);
		panel_2_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date");
		lblNewLabel_1_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(403, 3, 166, 24);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("$   1000000");
		lblNewLabel_1_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(18, 31, 189, 24);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("28/10/2005");
		lblNewLabel_1_2_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(402, 33, 166, 24);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Account type");
		lblNewLabel_1_2_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2.setBounds(635, 23, 166, 24);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Checking account");
		lblNewLabel_1_2_2_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2_1.setBounds(629, 67, 241, 24);
		panel_1.add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Last transaction");
		lblNewLabel_1_3.setForeground(new Color(155, 160, 164));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(17, 266, 138, 24);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Income - $1000000");
		lblNewLabel_1_3_1.setForeground(new Color(11, 163, 2));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(183, 266, 177, 24);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Income - $1000000");
		lblNewLabel_1_3_1_1.setForeground(new Color(163, 8, 18));
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1.setBounds(395, 263, 177, 24);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Availble");
		lblNewLabel_1_2_2_2.setForeground(new Color(155, 160, 164));
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2_2.setBounds(630, 235, 166, 24);
		panel_1.add(lblNewLabel_1_2_2_2);
		
		JLabel lblJrtBank_1_1_1_2 = new JLabel("$ 1000000");
		lblJrtBank_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblJrtBank_1_1_1_2.setForeground(Color.WHITE);
		lblJrtBank_1_1_1_2.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_1_2.setBounds(629, 266, 164, 23);
		panel_1.add(lblJrtBank_1_1_1_2);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Transaction limit per day");
		lblNewLabel_1_2_2_2_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2_2_1.setBounds(629, 314, 234, 24);
		panel_1.add(lblNewLabel_1_2_2_2_1);
		
		JLabel lblJrtBank_1_1_1_2_1 = new JLabel("$ 1000");
		lblJrtBank_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblJrtBank_1_1_1_2_1.setForeground(Color.WHITE);
		lblJrtBank_1_1_1_2_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_1_2_1.setBounds(632, 349, 164, 23);
		panel_1.add(lblJrtBank_1_1_1_2_1);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Card info");
		lblNewLabel_1_2_2_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2_1_1.setBounds(630, 386, 166, 24);
		panel_1.add(lblNewLabel_1_2_2_1_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(180, 82, 2), 3));
		panel_3_1.setBackground(new Color(27, 28, 29));
		panel_3_1.setBounds(631, 418, 248, 143);
		panel_1.add(panel_3_1);
		
		JLabel lblJrtBank_1_1_2 = new JLabel("JRT BANK");
		lblJrtBank_1_1_2.setForeground(new Color(155, 160, 164));
		lblJrtBank_1_1_2.setFont(new Font("Courier New", Font.BOLD, 20));
		lblJrtBank_1_1_2.setBackground(new Color(155, 160, 164));
		lblJrtBank_1_1_2.setBounds(136, 12, 96, 23);
		panel_3_1.add(lblJrtBank_1_1_2);
		
		JLabel lblJrtBank_1_1_1_3 = new JLabel("1234 5678");
		lblJrtBank_1_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJrtBank_1_1_1_3.setForeground(Color.WHITE);
		lblJrtBank_1_1_1_3.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_1_3.setBounds(136, 46, 103, 23);
		panel_3_1.add(lblJrtBank_1_1_1_3);
		
		JLabel lblJrtBank_1_1_1_1_5 = new JLabel("28/10/2005");
		lblJrtBank_1_1_1_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblJrtBank_1_1_1_1_5.setForeground(Color.WHITE);
		lblJrtBank_1_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_5.setBounds(143, 77, 97, 23);
		panel_3_1.add(lblJrtBank_1_1_1_1_5);
		
		JLabel lblJrtBank_1_1_2_1 = new JLabel("BANK");
		lblJrtBank_1_1_2_1.setForeground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_2_1.setBackground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_1.setBounds(10, 11, 96, 23);
		panel_3_1.add(lblJrtBank_1_1_2_1);
		
		JLabel lblJrtBank_1_1_2_2 = new JLabel("Number");
		lblJrtBank_1_1_2_2.setForeground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_2.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_2_2.setBackground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_2.setBounds(7, 45, 96, 23);
		panel_3_1.add(lblJrtBank_1_1_2_2);
		
		JLabel lblJrtBank_1_1_2_2_1 = new JLabel("Date create");
		lblJrtBank_1_1_2_2_1.setForeground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_2_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_2_2_1.setBackground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_2_1.setBounds(6, 76, 129, 23);
		panel_3_1.add(lblJrtBank_1_1_2_2_1);
		
		JLabel lblJrtBank_1_1_2_2_1_1 = new JLabel("Currency");
		lblJrtBank_1_1_2_2_1_1.setForeground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_2_1_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblJrtBank_1_1_2_2_1_1.setBackground(new Color(155, 160, 164));
		lblJrtBank_1_1_2_2_1_1.setBounds(6, 111, 114, 23);
		panel_3_1.add(lblJrtBank_1_1_2_2_1_1);
		
		JLabel lblJrtBank_1_1_1_1_5_1 = new JLabel("USD");
		lblJrtBank_1_1_1_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJrtBank_1_1_1_1_5_1.setForeground(Color.WHITE);
		lblJrtBank_1_1_1_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJrtBank_1_1_1_1_5_1.setBounds(136, 111, 97, 23);
		panel_3_1.add(lblJrtBank_1_1_1_1_5_1);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(27, 28, 29));
		panel_4.setBounds(16, 310, 599, 263);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 577, 49);
		panel_4.add(panel_5);
		
//		JPanel panel_5 = new JPanel();
//		panel_5.setBackground(new Color(64, 49, 43));
//		panel_5.setBounds(6, 6, 579, 49);
//		panel_4.add(panel_5);
		scrollPane.setBounds(16, 310, 599, 263);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Đặt giá trị unit increment
		panel_1.add(scrollPane);
		
		addPanel();
	}

	private void addPanel() {
		JPanel[] jPanel = new JPanel[20];
		int x = 6, y = 6;
		int width = 585;
		int height = 49;
		for (int i = 0; i < 20; i++) {
			jPanel[i] = new JPanel();
			jPanel[i].setBounds(x, y, width, height);
			jPanel[i].setBackground(new Color(64, 49, 43));
			panel_4.add(jPanel[i]);
			y += height + 5;
		}
		
		panel_4.setPreferredSize(new Dimension(585, 1081));
	}
}
