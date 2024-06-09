package SERVER;

import java.io.BufferedReader;
import java.io.PrintWriter;
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
		
	}
}
