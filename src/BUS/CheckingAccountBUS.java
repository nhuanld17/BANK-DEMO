package BUS;

import DAO.CheckingAccountDAO;
import DAO.DBcon;

public class CheckingAccountBUS {

	public void createCheckingAccount(String payeeAddress, double checkingInit) {
		new CheckingAccountDAO().createCheckingAccount(payeeAddress, checkingInit);
	}
}
