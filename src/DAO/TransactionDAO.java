package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

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
}
