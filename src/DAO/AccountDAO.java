package DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.HexFormat;

public class AccountDAO {
	
	private static boolean verify(String password, String hashPassword) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myCheckSum = HexFormat.of().formatHex(digest).toUpperCase();
		
		return myCheckSum.equals(hashPassword);
	}

	public boolean isValidAccount(String username, String password) {
		String hashPassword = "";
		String query = "SELECT password FROM fk_bank.admin WHERE username = '"+username+"'";
		try {
			ResultSet resultSet = new DBcon().queryDB(query);
			while (resultSet.next()) {
				hashPassword = resultSet.getString("password");
			}
			
			if (hashPassword.isEmpty()) {
				return false;
			}
			
			return verify(password, hashPassword);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
