package BUS;

import DAO.CheckingAccountDAO;
import DAO.DBcon;

public class CheckingAccountBUS {

	public void createCheckingAccount(String payeeAddress, double checkingInit) {
		new CheckingAccountDAO().createCheckingAccount(payeeAddress, checkingInit);
	}

	public void adminTransferToCheckingAcc(String payeeName, double amount) {
		new CheckingAccountDAO().adminTransferToCheckingAcc(payeeName,amount);
	}

	public String getInfo(String username) {
		return new CheckingAccountDAO().getInfo(username);
	}
}
