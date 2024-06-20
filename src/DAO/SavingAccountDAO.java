package DAO;

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
}
