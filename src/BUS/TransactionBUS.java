package BUS;

import DAO.TransactionDAO;

public class TransactionBUS {

	public String getIncomAndExpense(String username) {
		return new TransactionDAO().getIncomAndExpense(username);
	}

}
