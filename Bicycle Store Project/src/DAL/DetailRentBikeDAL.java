package src.DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import src.DTO.Bicycle;
import src.DTO.Rent;

public class DetailRentBikeDAL {
	ConnectDatabase DB = new ConnectDatabase();
	
	
	//Insert hoa don moi thue duy nhat mot xe dap
	public Boolean orderBike(Rent rentbike) {
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, rentbike.getId());
				pr.setInt(2, rentbike.getDeposit());
				pr.setString(3, rentbike.getCustomer());
				pr.setString(4, rentbike.getBicycle());
				pr.setString(5, rentbike.getRentDate());
				pr.setString(6, rentbike.getReturnDate());
				pr.setString(7, "Đang thuê");
				
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
	
	//Kiem tra hoa don co ton tai trong cua hang hay chua 
	public Boolean detaiOderBike(String  id) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "SELECT * FROM hoadon WHERE hdid";
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
	
	//hoa don tra ve list xe dap
	public Vector<Bicycle> SeachBicycleByName (String hoadonid) {
		Boolean result = false;
		Vector<Bicycle> list = new Vector<Bicycle>();
		if(DB.openConection()) {
			String query = "SELECT * FROM bicycle WHERE id =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, hoadonid);
				
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					Bicycle bike = new Bicycle();
					bike.setId(rs.getString("bikeid"));
					bike.setName(rs.getString("name"));
					bike.setType(rs.getString("type"));
					bike.setStoreId(rs.getString("storeid"));
					bike.setPricePerH(rs.getInt("priceh"));
					bike.setStatus(rs.getString("status"));
					list.add(bike);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
}
