package BUS;

import DAO.TransactionDAO;

public class TransactionBUS {

	public String getIncomAndExpense(String username) {
		return new TransactionDAO().getIncomAndExpense(username);
	}

	public void saveTransactionHistory(String sender, String receiver, double money, String mess) {
		new TransactionDAO().saveTransactionHistory(sender, receiver, money, mess);
	}

	public String getListHistoryTransaction(String username) {
		return new TransactionDAO().getListHistoryTransaction(username);
	}

	public String getAllTransactionHistory() {
		return new TransactionDAO().getAllHistoryTransaction();
	}

	public int getTotalTransaction() {
		return new TransactionDAO().getTotalTransaction();
	}

	public String getChartData() {
		return new TransactionDAO().getChartData();
	}

}
