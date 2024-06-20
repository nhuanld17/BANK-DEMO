package DAO;

public class CheckingAccountDAO {

	public void createCheckingAccount(String payeeAddress, double checkingInit) {
		String query = "INSERT INTO fk_bank.checkingaccount(owner, transactionlimit, balance)"
				+ " VALUES('"+payeeAddress+"', '"+750+"', '"+checkingInit+"')";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
