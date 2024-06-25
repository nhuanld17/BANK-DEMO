package DAO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TransactionDAO {

	public String getIncomAndExpense(String username) {
		String res = "";
		String query1 = "SELECT SUM(amount) FROM fk_bank.transaction_history WHERE receiver = '"+username+"'";
		String query2 = "SELECT SUM(amount) FROM fk_bank.transaction_history WHERE sender = '"+username+"'";
		try {
			ResultSet resultSet1 = new DBcon().queryDB(query1);
			ResultSet resultSet2 = new DBcon().queryDB(query2);
			
			while (resultSet1.next()) {
				double income = resultSet1.getDouble("SUM(amount)");
				res += income+"_";
			}
			
			while (resultSet2.next()) {
				double expense = resultSet2.getDouble("SUM(amount)");
				res += expense;
			}
			
			return res;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0"+"_"+"0";
	}

	public void saveTransactionHistory(String sender, String receiver, double money, String mess) {
		double currentSenderChecking = new CheckingAccountDAO().getCurrentCheckingBalance(sender);
		double currentReceiverChecking = new CheckingAccountDAO().getCurrentCheckingBalance(receiver);
		
		System.out.println("Sender: "+currentReceiverChecking+", Receiver: "+currentReceiverChecking);
		
		currentSenderChecking -= money;
		currentReceiverChecking += money;
		
		// Lấy thời gian hiện tại
		java.util.Date date = new java.util.Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		String query1 = "INSERT INTO fk_bank.transaction_history(sender, receiver, amount, message, time)"
				+ " VALUES('"+sender+"', '"+receiver+"', '"+money+"', '"+mess+"', '"+timestamp+"')";
		
		String query2 = "UPDATE fk_bank.checkingaccount SET balance = '"+currentSenderChecking+"'"
				+ " WHERE owner = '"+sender+"'";
		
		String query3 = "UPDATE fk_bank.checkingaccount SET balance = '"+currentReceiverChecking+"'"
				+ " WHERE owner = '"+receiver+"'";
		
		try {
			new DBcon().updateDB(query1);
			new DBcon().updateDB(query2);
			new DBcon().updateDB(query3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getListHistoryTransaction(String username) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String list = "";
		String query = "SELECT * FROM fk_bank.transaction_history WHERE sender = '"+username+"' OR receiver = '"+username+"'"
				+ " ORDER BY time DESC;";
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				Date time = resultSet.getDate("time");
				String sender = resultSet.getString("sender");
				String receiver = resultSet.getString("receiver");
				String message = resultSet.getString("message");
				double money = resultSet.getDouble("amount");
				list += dateFormat.format(time)+"_"+sender+"_"+receiver+"_"+message+"_"+money+"__";
			}
			
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getAllHistoryTransaction() {
		String list = "";
		String query = "SELECT * FROM fk_bank.transaction_history ORDER BY time DESC";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				Date time = resultSet.getDate("time");
				String sender = resultSet.getString("sender");
				String receiver = resultSet.getString("receiver");
				String message = resultSet.getString("message");
				double amount = resultSet.getDouble("amount");
				
				list += simpleDateFormat.format(time)+"_"+sender+"_"+receiver+"_"+message+"_"+amount+"__";
			}
			
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int getTotalTransaction() {
		int total = 0;
		String query = "SELECT COUNT(*) FROM fk_bank.transaction_history";
		
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				total = resultSet.getInt("COUNT(*)");
			}
			
			return total;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	public String getChartData() {
		String data = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentDate = LocalDate.now();
		LocalDate[] date = new LocalDate[7];
		
		LocalDate start = currentDate.minusDays(6);
		double[] amount = new double[7];
		for (int i = 0; i < 7; i++) {
			date[i] = start.plusDays(i);
		}
		
		for (int i = 0; i < date.length; i++) {
			String query = "SELECT SUM(amount) FROM fk_bank.transaction_history WHERE DATE(time) = '"+date[i]+"'";
			
			try {
				ResultSet resultSet = new DBcon().queryDB(query);
				if (resultSet.next()) {
					amount[i] = resultSet.getDouble("SUM(amount)");
				}
				
				data += formatter.format(date[i]) + "_" + amount[i] +"__";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return data;
	}

}
