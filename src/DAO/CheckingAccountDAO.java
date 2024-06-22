package DAO;

import java.sql.ResultSet;

public class CheckingAccountDAO {

	public void createCheckingAccount(String payeeAddress, double checkingInit) {
		String query = "INSERT INTO fk_bank.checkingaccount(owner, transactionlimit, balance)"
				+ " VALUES('"+payeeAddress+"', '"+750+"', '"+checkingInit+"')";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adminTransferToCheckingAcc(String payeeName, double amount) {
		double currentCheckingBalance = getCurrentCheckingBalance(payeeName);
		currentCheckingBalance = currentCheckingBalance + amount;
		
		String query = "UPDATE fk_bank.checkingaccount SET balance = '"+currentCheckingBalance+"'"
				+ " WHERE owner = '"+payeeName+"'";
		
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private double getCurrentCheckingBalance(String payeeName) {
		double currentBalance = 0;
		String query = "SELECT balance FROM fk_bank.checkingaccount WHERE owner = '"+payeeName+"'";
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			
			while (resultSet.next()) {
				currentBalance = resultSet.getDouble("balance");
			}
			return currentBalance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currentBalance;
	}

	public String getInfo(String username) {
		String info = "";
		String query = "SELECT * FROM fk_bank.checkingaccount WHERE owner = '"+username+"'";
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				int accNumber = resultSet.getInt("accountnumber");
				double transactionLimit = resultSet.getDouble("transactionlimit");
				double balance = resultSet.getDouble("balance");
				
				info = accNumber+"_"+transactionLimit+"_"+balance;
			}
			
			return info;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}

}
