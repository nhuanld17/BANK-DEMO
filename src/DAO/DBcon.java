package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcon {
	private String status;
	private String url = "jdbc:mysql://localhost:3306/fk_bank";
	private String user = "root";
	private String pwd = "nhuan.142857";
	Connection con;
	
	public DBcon() {
		try {
			con = DriverManager.getConnection(url,user,pwd);
			status = "OK";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "KO";
		}
	}
	
	public Connection getCon() {
		return con;
	}
	
    public ResultSet queryDB(String query) throws Exception {
        PreparedStatement preparedStatement = this.getCon().prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public int updateDB(String query) throws Exception {
        PreparedStatement preparedStatement = this.getCon().prepareStatement(query);
        return preparedStatement.executeUpdate();
    }
    
    public static void main(String[] args) {
		new DBcon();
	}
}
