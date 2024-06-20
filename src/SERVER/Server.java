package SERVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import BUS.AccountBUS;
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
			}
		}
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
}
