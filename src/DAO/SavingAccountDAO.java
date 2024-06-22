package DAO;

import java.sql.ResultSet;

public class SavingAccountDAO {

	public void createSavingAccount(String payeeAddress, double savingInit) {
		String query = "INSERT INTO fk_bank.savingaccount(owner, transactionlimit, balance)"
				+ " VALUES('"+payeeAddress+"', '"+750+"', '"+savingInit+"')";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adminTransferToSavingAccount(String payeeName, double amount) {
		double currentSavingBalance = getCurrentSavingBalance(payeeName);
		currentSavingBalance += amount;
		
		String query = "UPDATE fk_bank.savingaccount SET balance = '"+currentSavingBalance+"' WHERE owner = '"+payeeName+"'";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private double getCurrentSavingBalance(String payeeName) {
		double currentBalance = 0;
		String query = "SELECT balance FROM fk_bank.savingaccount WHERE owner = '"+payeeName+"'";
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
		String query = "SELECT * FROM fk_bank.savingaccount WHERE owner = '"+username+"'";
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
