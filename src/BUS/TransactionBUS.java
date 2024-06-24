package BUS;

import DAO.TransactionDAO;

public class TransactionBUS {

	public String getIncomAndExpense(String username) {
		return new TransactionDAO().getIncomAndExpense(username);
	}

	public void saveTransactionHistory(String sender, String receiver, double money, String mess) {
		new TransactionDAO().saveTransactionHistory(sender, receiver, money, mess);
	}

}
