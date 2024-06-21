package DAO;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import SIDEFUNCTION.HashPassword;

public class ClientDAO {

	public void createClient(String clientFullName, String email, String payeeAddress, String password) {
		String hashedPassword = new HashPassword(password).getPasswordHashed();
		LocalDate currentDate = LocalDate.now();
		String query = "INSERT INTO clients(fullname, payee_name, email, password, date_created) " + " VALUES('"
				+ clientFullName + "', '" + payeeAddress + "', " + " '" + email + "', '" + hashedPassword + "', '"
				+ currentDate + "')";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getPayeeList() {
		ArrayList<String> payeeList = new ArrayList<>();
		String query = "SELECT payee_name FROM fk_bank.clients";
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				String payeeName = resultSet.getString("payee_name");
				payeeList.add(payeeName);
			}

			return payeeList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	// TEST: Lấy thêm gmail
	public String getUserList() {
		String result = "";
		String query = "SELECT fullname, payee_name, checkingaccount.accountnumber, savingaccount.accountnumber, date_created, email"
				+ " FROM clients INNER JOIN checkingaccount ON clients.payee_name = checkingaccount.owner "
				+ " INNER JOIN savingaccount ON clients.payee_name = savingaccount.owner";
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				String fullname = resultSet.getString("fullname");
				String payeename = resultSet.getString("payee_name");
				int checkingAccountNumber = resultSet.getInt("checkingaccount.accountnumber");
				int savingAccountNumber = resultSet.getInt("savingaccount.accountnumber");
				Date dateCreated = resultSet.getDate("date_created");
				String email = resultSet.getString("email");
				
				result += fullname+"_"+payeename+"_"+checkingAccountNumber+"_"+savingAccountNumber+"_"+dateCreated+"_"+email+"__";
			}
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String searchClientByPayeeName(String payeeName) {
		String users = "";
		String query = "SELECT fullname, payee_name, checkingaccount.accountnumber, savingaccount.accountnumber, date_created "
				+ " FROM clients INNER JOIN checkingaccount ON clients.payee_name = checkingaccount.owner "
				+ " INNER JOIN savingaccount ON clients.payee_name = savingaccount.owner"
				+ " WHERE payee_name LIKE '%"+payeeName+"%'";
		
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			
			while (resultSet.next()) {
				String fullname = resultSet.getString("fullname");
				String payeename = resultSet.getString("payee_name");
				int checkingAccountNumber = resultSet.getInt("checkingaccount.accountnumber");
				int savingAccountNumber = resultSet.getInt("savingaccount.accountnumber");
				Date dateCreated = resultSet.getDate("date_created");
				
				users += fullname+"_"+payeename+"_"+checkingAccountNumber+"_"+savingAccountNumber+"_"+dateCreated+"__";
			}
			
			return users;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public void updateClientInfo(String newFullName, String newEmail, String newPayeeName, String oldPayeeName) {
		String query = "UPDATE fk_bank.clients SET payee_name = '"+newPayeeName+"', fullname = '"+newFullName+"', "
				+ " email = '"+newEmail+"'"
				+ " WHERE payee_name = '"+oldPayeeName+"'";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteClient(String payeeName) {
		String query = "DELETE FROM fk_bank.clients WHERE payee_name = '"+payeeName+"'";
		try {
			new DBcon().updateDB(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
