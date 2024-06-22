package BUS;

import DAO.SavingAccountDAO;

public class SavingAccountBUS {

	public void createSavingAccount(String payeeAddress, double savingInit) {
		new SavingAccountDAO().createSavingAccount(payeeAddress, savingInit);
	}

	public void adminTransferToSavingAccount(String payeeName, double amount) {
		new SavingAccountDAO().adminTransferToSavingAccount(payeeName, amount);
	}

	public String getInfo(String username) {
		return new SavingAccountDAO().getInfo(username);
	}

}
