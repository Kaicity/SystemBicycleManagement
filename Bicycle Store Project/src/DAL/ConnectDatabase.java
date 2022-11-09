package src.DAL;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDatabase {
	
	public Connection con;
	private final String username ="root";
	private final String password = "";
	private final String url = "jdbc:mysql://localhost:3306/bikesystem";
	
	public boolean openConection() {
		
		try {
			con = DriverManager.getConnection(url,username,password);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void closeConection() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
