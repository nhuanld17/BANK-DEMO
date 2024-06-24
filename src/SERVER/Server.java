package SERVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import BUS.AccountBUS;
import BUS.ClientBUS;
import DAO.DBcon;

public class Server {
	public static HashMap<String, ClientHandler> clients = new HashMap<>();
	
	public Server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8000);
		System.out.println("Server started");
		setMaxConnecttion();
		
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("New Client Connected");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			
			String taskname = reader.readLine();
			System.out.println("NEWTASK: "+taskname);
			
			if (taskname.startsWith("ADMINLOGIN")) {
				String[] info = taskname.split("_");
				String username = info[1];
				String password = info[2];
				
				// Kiểm tra đăng nhập trùng lặp
				if (isUserAlreadyLoggedIn(username)) {
					writer.println("DUPLICATED_LOGIN");
				}
				
				// Kiểm tra tài khoản và mật khẩu
				else if (new AccountBUS().isValidAccount(username, password)) {
					writer.println("ADMIN_LOGIN_SUCCESS");
					ClientHandler clientHandler = new ClientHandler(username, reader, writer, clients);
				}else {
					writer.println("ADMIN_LOGIN_FAILED");
				}
			} else if (taskname.startsWith("CHECK_PAYEE_MAIL:")) {
				String info = taskname.substring(17);
				String[] infos = info.split("_");
				
				String payeename = infos[0];
				String email = infos[1];
				
				if (isValidPayeeAndEmail(payeename, email)) {
					writer.println("PAYEE_EMAIL_VALID");
				} else {
					writer.println("PAYEE_EMAIL_INVALID");
				}
			} else if (taskname.startsWith("UPDATEPASS:")) {
				String info = taskname.substring(11);
				String[] infos = info.split("_");
				
				new ClientBUS().updatePass(infos[0], infos[1]);
			} else if (taskname.startsWith("CLIENTLOGIN")) {
				String[] info = taskname.split("_");
				String username = info[1];
				String password = info[2];
				
				// Kiểm tra đăng nhập trùng lặp
				if (isUserAlreadyLoggedIn(username)) {
					writer.println("DUPLICATED_LOGIN");
				}
				
				// Kiểm tra tài khoản và mật khẩu
				else if (new AccountBUS().isValidClientAccount(username, password)) {
					writer.println("CLIENT_LOGIN_SUCCESS");
					ClientHandler clientHandler = new ClientHandler(username, reader, writer, clients);
				}else {
					writer.println("CLIENT_LOGIN_FAILED");
				}
			}
		}
	}

	private boolean isValidPayeeAndEmail(String payeename, String email) {
		return new ClientBUS().checkPayeeAndEmail(payeename, email);
	}

	private boolean isUserAlreadyLoggedIn(String username) {
		return clients.containsKey(username);
	}

	private void setMaxConnecttion() {
		try {
			new DBcon().updateDB("SET GLOBAL max_connections = 100000");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Server();
	}

	public static void sendTransferNotification(String payeeName, String message, ClientHandler sender) {
		for (ClientHandler client : clients.values()) {
			if (client != sender && client.getUsername().equals(payeeName)) {
				client.sendTransferNotification(message);
			}
		}
	}

	public static void sendBalanceChangeNotification(String sender, String receiver, String message, String description,
			double money, ClientHandler clientSender) {
		for (ClientHandler client : clients.values()) {
			// TODO: Gửi thông báo cho người nhận
			if (client != clientSender && client.getUsername().equals(receiver)) {
				client.sendBalanceChangeNotification(sender, receiver, description, money);
			}
		}
	}
}
