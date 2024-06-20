package SIDEFUNCTION;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class HashPassword {
	private String password;

	public HashPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordHashed() {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			
			byte[] digest = messageDigest.digest();
			String passwordHashed = HexFormat.of().formatHex(digest).toUpperCase();
			
			return passwordHashed;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private boolean verify(String hashFromDB) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			byte[] digest = messageDigest.digest();
			String checkSum = HexFormat.of().formatHex(digest).toUpperCase();
			
			return checkSum.equals(hashFromDB);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
