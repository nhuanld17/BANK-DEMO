package SERVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import BUS.CheckingAccountBUS;
import BUS.ClientBUS;
import BUS.SavingAccountBUS;
import BUS.TransactionBUS;
import DAO.ClientDAO;

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
			/*
			 * phần này lấy danh sách payeeName từ db và gửi tới admin để khi tạo client, admin có thể tránh việc tạo
			 * client với payeeName giống nhau
			 */
			if (this.username.equals("admin")) {
				sendListPayeeName();
				sendListUser();
			}else {
				sendName();
				sendDateCreated();
				sendCheckingAccountInfo();
				sendSavingAccountInfo();
				sendIncomeAndExpense();
			}
			while (true) {
				String message = reader.readLine();
				
				if (message == null) {
					throw new IOException("Client disconnected");
				}
				
				if ("LOGOUT".equals(message)) {
					break;
				} else if (message.startsWith("CREATECLIENT")) {
					System.out.println(message);
					String[] infos = message.split("_");
					String clientFullName = infos[1];
					String email = infos[2];
					String payeeAddress = infos[3];
					String password = infos[4];
					double checkingInit = Double.valueOf(infos[5]);
					double savingInit = Double.valueOf(infos[6]);
					
					new ClientBUS().createClient(clientFullName, email, payeeAddress, password);
					new SavingAccountBUS().createSavingAccount(payeeAddress, savingInit);
					new CheckingAccountBUS().createCheckingAccount(payeeAddress, checkingInit);
					
					sendListPayeeName();
					sendListUser();
				} else if (message.startsWith("SEARCH:")) {
					System.out.println("CLIENT_REQUEST:SEARCH");
					String payeeName = message.substring(7);
					String users ="SEARCHRESULT:" + new ClientBUS().searchClientByPayeeName(payeeName);
					System.out.println("Kết quả tìm kiếm: "+users);
					this.writer.println(users);
				} else if (message.equals("GET_ALL_USERS")) {
					sendListPayeeName();
					sendListUser();
				} else if (message.startsWith("UPDATECLIENT:")) {
					String infoStr = message.substring(13);
					String[] infos = infoStr.split("_");
					String newFullName = infos[0];
					String newEmail = infos[1];
					String newPayeeName = infos[2];
					String oldPayeeName = infos[3];
					
					new ClientBUS().updateClientInfo(newFullName, newEmail, newPayeeName, oldPayeeName);
					sendListPayeeName();
					sendListUser();
				} else if (message.startsWith("DELETE_CLIENT:")) {
					String payeeName = message.substring(14);
					
					new ClientBUS().deleteClient(payeeName);
					sendListPayeeName();
					sendListUser();
				} else if (message.startsWith("SEARCH_IN_TRANSACTION:")) {
					System.out.println(message);
					String payeeName = message.substring(22);
					
					String users ="SEARCHINTRANSACTION:" + new ClientBUS().searchClientByPayeeName(payeeName);
					System.out.println("Kết quả tìm kiếm: "+users);
					this.writer.println(users);
				} else if (message.startsWith("TRANSFER_CHECKING:")) {
					String info = message.substring(18);
					String[] infos = info.split("_");
					String payeeName = infos[0];
					double amount = Double.valueOf(infos[1]);
					
					new CheckingAccountBUS().adminTransferToCheckingAcc(payeeName, amount);
					
					// Gửi tin nhắn cho client để cập nhật
				} else if (message.startsWith("TRANSFER_SAVING:")) {
					String info = message.substring(16);
					String[] infos = info.split("_");
					String payeeName = infos[0];
					double amount = Double.valueOf(infos[1]);
					
					new SavingAccountBUS().adminTransferToSavingAccount(payeeName, amount);
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

	private void sendName() {
		String name = "NAME:" + removeAccents(new ClientBUS().getName(this.username));
		this.writer.println(name);
	}

	private void sendIncomeAndExpense() {
		String incomeAndExpense = "INEX:"+ new TransactionBUS().getIncomAndExpense(this.username);
		this.writer.println(incomeAndExpense);
	}

	private void sendSavingAccountInfo() {
		String savingInfo = "SAVING_ACC_INFO:" + new SavingAccountBUS().getInfo(this.username);
		this.writer.println(savingInfo);
	}

	private void sendCheckingAccountInfo() {
		String checkingInfo = "CHECKING_ACC_INFO:" + new CheckingAccountBUS().getInfo(this.username);
		this.writer.println(checkingInfo);
	}

	private void sendDateCreated() {
		String dateCreated ="DATECREATED:" + new ClientBUS().getDateCreated(this.username);
		this.writer.println(dateCreated);
	}

	private void sendListUser() {
		String listUser ="LIST_USERS:" + new ClientBUS().getUserList();
		this.writer.println(listUser);
	}

	private void sendListPayeeName() {
		ArrayList<String> payeeList = new ClientBUS().getPayeeList();
		String listPayeeStr = "LISTPAYEENAME_"+ String.join("_", payeeList);
		this.writer.println(listPayeeStr);
	}
	
	private String removeAccents(String name) {
		// Chuẩn hóa tên, chuyển đổi tiếng việt thành kí tự tổ hợp
		String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
		
		// Loại bỏ dấu bằng biểu thức chính quy
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		
		return pattern.matcher(normalized).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
	}
}
