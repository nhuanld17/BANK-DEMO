package DAO;

import java.sql.ResultSet;

public class TransactionDAO {

	public String getIncomAndExpense(String username) {
		String res = "";
		String query1 = "SELECT SUM(amount) FROM fk_bank.transaction_history WHERE sender = '"+username+"' AND method = 'SEND TO'";
		String query2 = "SELECT SUM(amount) FROM fk_bank.transaction_history WHERE receiver = '"+username+"' AND method = 'RECEIVE FROM'";
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
}
