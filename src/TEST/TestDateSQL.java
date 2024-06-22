package TEST;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import DAO.DBcon;

public class TestDateSQL {
	public static void main(String[] args) {
		String username = "ldnhuan147";
		Date dateCreated = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String query = "SELECT date_created FROM fk_bank.clients WHERE payee_name = '" + username + "'";
		
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			
			while (resultSet.next()) {
				dateCreated = resultSet.getDate("date_created");
			}
			
			System.out.println(simpleDateFormat.format(dateCreated));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
