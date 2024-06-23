package BUS;

import java.util.ArrayList;

import DAO.ClientDAO;

public class ClientBUS {

	public void createClient(String clientFullName, String email, String payeeAddress, String password) {
		new ClientDAO().createClient(clientFullName, email, payeeAddress, password);
	}

	public ArrayList<String> getPayeeList() {
		return new ClientDAO().getPayeeList();
	}

	public String getUserList() {
		return new ClientDAO().getUserList();
	}

	public String searchClientByPayeeName(String payeeName) {
		return new ClientDAO().searchClientByPayeeName(payeeName);
	}

	public void updateClientInfo(String newFullName, String newEmail, String newPayeeName, String oldPayeeName) {
		new ClientDAO().updateClientInfo(newFullName, newEmail, newPayeeName, oldPayeeName);
	}

	public void deleteClient(String payeeName) {
		new ClientDAO().deleteClient(payeeName);
	}

	public boolean checkPayeeAndEmail(String payeename, String email) {
		return new ClientDAO().checkPayeeAndEmail(payeename, email);
	}

	public void updatePass(String payeename, String pass) {
		new ClientDAO().updatePass(payeename, pass);
	}

	public String getDateCreated(String username) {
		return new ClientDAO().getDateCreated(username);
	}

	public String getName(String username) {
		return new ClientDAO().getName(username);
	}

}
