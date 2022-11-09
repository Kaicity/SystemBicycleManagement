package src.DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.DTO.Bicycle;
import src.DTO.Rent;

public class DetailRentBikeDAL {
	ConnectDatabase DB = new ConnectDatabase();
	
	public Boolean orderBike(Rent re) {
		
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO hoadon VALUES(?,?,?,?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, re.getId());
				pr.setString(2, re.getCustomer().getCccd());
				pr.setString(3, re.getBicycle().getId());
				pr.setString(4, re.getStore().getId());
				pr.setInt(5, re.getDeposit());
				pr.setDate(6, (Date) re.getRentDate());
				pr.setDate(7, (Date) re.getReturnDate());
			
				
				if(pr.executeUpdate() >= 0) {
					result = true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeConection();
			}
		}
		return result;
	}
	
	
	public Boolean detaiOderBike(Rent re) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "INSERT INTO chitiethoadon VALUES(?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, re.getId());
				pr.setString(2, re.getCustomer().getCccd());
				pr.setString(3, re.getBicycle().getId());
				
				if(pr.executeUpdate() >= 0) {
					result = true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeConection();
			}
		}	
		return false;
	}
	
	
}
