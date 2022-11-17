package src.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


import src.DTO.Transaction;


public class TransactionDAL {
	
ConnectDatabase DB = new ConnectDatabase();
	
	

	public Vector<Transaction> selectTransaction() {
		Vector<Transaction> list = new Vector<Transaction>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM `hoadon`,`xedap` WHERE `hoadon`.`bikeid`=`xedap`.`bikeid`;";
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				ResultSet rs = pr.executeQuery(query);
			
				
				while(rs.next()) {
					Transaction Transaction = new Transaction();
					Transaction.setId(rs.getString("hdid"));
					Transaction.setIdBicycle(rs.getString("bikeid"));
					Transaction.setRentDate(rs.getString("rentdate"));
					Transaction.setReturnDate(rs.getString("returndate"));
					Transaction.setStatus(rs.getString("note"));
					
					list.add(Transaction);
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeConection();
			}
		}
		return list;
	}

	
		
}

