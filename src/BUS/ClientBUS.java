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

}
