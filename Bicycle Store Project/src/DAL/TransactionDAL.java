package src.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


import src.DTO.TransactionDTO;


public class TransactionDAL {
	
ConnectDatabase DB = new ConnectDatabase();
	
	

	public Vector<TransactionDTO> selectTransaction() {
		Vector<TransactionDTO> list = new Vector<TransactionDTO>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM `hoadon`,`xedap` WHERE `hoadon`.`bikeid`=`xedap`.`bikeid`;";
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				ResultSet rs = pr.executeQuery(query);
			
				
				while(rs.next()) {
					TransactionDTO Transaction = new TransactionDTO();
					Transaction.setId(rs.getString("hdid"));
					Transaction.setIdBicycle(rs.getString("bikeid"));
					Transaction.setStatus(rs.getString("status"));
					Transaction.setRentDate(rs.getDate("date"));
					Transaction.setReturnDate(rs.getDate("returndate"));
					
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

