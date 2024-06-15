package SERVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class ClientHandler extends Thread{
	private BufferedReader reader;
	private PrintWriter writer;
	private HashMap<String, ClientHandler> clients;
	private String username;
	
	public ClientHandler(String username, BufferedReader reader, PrintWriter writer, HashMap<String, ClientHandler> clients) {
		this.username = username;
		this.reader = reader;
		System.out.println(username+" was added to Hashmap");
		this.writer = writer;
		clients.put(this.username, this);
		this.clients = clients;
		start();
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				String message = reader.readLine();
				
				if (message == null) {
					throw new IOException("Client disconnected");
				}
				
				if ("LOGOUT".equals(message)) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clients.remove(username);
			System.out.println("Removed: "+username);
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
