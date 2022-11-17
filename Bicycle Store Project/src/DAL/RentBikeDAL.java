package src.DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import src.DTO.Bicycle;
import src.DTO.Customer;
import src.DTO.Rent;

public class RentBikeDAL {
	
ConnectDatabase DB = new ConnectDatabase();
	
	//Lay du lieu tu danh sach xe dap
	/*
	 * public Vector<Bicycle> getBicycleList(){ Vector<Bicycle> list = new
	 * Vector<Bicycle>();
	 * 
	 * if(DB.openConection()) { String query = "SELECT * FROM bicycle"; try {
	 * Statement st = DB.con.createStatement(); ResultSet rs =
	 * st.executeQuery(query);
	 * 
	 * while(rs.next()) { Bicycle bike = new Bicycle();
	 * bike.setId(rs.getString("id")); bike.setName(rs.getString("tenxedap"));
	 * bike.setPricePerH(rs.getDouble("giathue"));
	 * bike.setStatus(rs.getString("tinhtrang"));
	 * bike.setType(rs.getString("loaixe"));
	 * 
	 * list.add(bike); }
	 * 
	 * }catch(SQLException e) { e.printStackTrace(); } finally {
	 * DB.closeConection(); } }
	 * 
	 * return list; }
	 */
	
	public Boolean add(Bicycle bike) {
		return false;
	}
		
		
	//chon cua hang co tat ca xe dap trong cua hang do
	public Vector<Bicycle> selectStoreHasBike(String storeid) {
		Vector<Bicycle> list = new Vector<Bicycle>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM `xedap` WHERE `xedap`.`storeid` = '"+storeid+"' AND status ='Chưa thuê'";
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				ResultSet rs = pr.executeQuery(query);
			
				
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
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeConection();
			}
		}
		return list;
	}
	
	
//	public Boolean orderBike(Rent rentbike) {
//		Boolean result = false;
//		if(DB.openConection()) {
//			String query = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?)";
//			PreparedStatement pr;
//			
//			try {
//				pr = DB.con.prepareStatement(query);
//				pr.setString(1, rentbike.getId());
//				pr.setInt(2, rentbike.getDeposit());
//				pr.setString(3, rentbike.getCustomer());
//				pr.setString(4, rentbike.getBicycle());
//				pr.setString(5, rentbike.getRentDate());
//				pr.setString(6, rentbike.getReturnDate());
//				pr.setString(7, rentbike.get);
//				
//				if(pr.executeUpdate() >= 0) {
//					result = true;
//				}
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				DB.closeConection();
//			}
//		}
//		return result;
//	}

}
