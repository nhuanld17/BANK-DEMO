package BUS;

import DAO.AccountDAO;

public class AccountBUS {

	public boolean isValidAccount(String username, String password) {
		return new AccountDAO().isValidAccount(username, password);
	}

	public boolean isValidClientAccount(String username, String password) {
		return new AccountDAO().isValidClientAccount(username, password);
	}
	
}
