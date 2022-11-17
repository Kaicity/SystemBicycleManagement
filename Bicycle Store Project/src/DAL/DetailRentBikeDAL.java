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
	
	
	//Insert hoa don moi thue duy nhat 1 xe dap
	public Boolean orderBike(Rent re) {
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pr;
			
			try {
//				pr = DB.con.prepareStatement(query);
//				pr.setString(1,null);
//				pr.setString(2, re.getCustomer().getCccd());
//				//chi them dc 1 xe
//				pr.setString(3, re.getBicycle().getId());
//				pr.setString(4, re.getRentDate());
//				pr.setString(5, re.getReturnDate());
//				
//				pr.setDate(6, null);
//				
//				pr.setString(7,"Đang Thuê");
			
				
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
	
	//add
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
