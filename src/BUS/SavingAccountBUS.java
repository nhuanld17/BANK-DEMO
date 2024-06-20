package BUS;

import DAO.SavingAccountDAO;

public class SavingAccountBUS {

	public void createSavingAccount(String payeeAddress, double savingInit) {
		new SavingAccountDAO().createSavingAccount(payeeAddress, savingInit);
	}

}
