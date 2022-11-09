package src.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import src.DTO.Bicycle;
import src.DTO.Customer;

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
	
	
		
		
	//chon cua hang co tat ca xe dap trong cua hang do
	public Vector<Bicycle> selectStoreHasBike(String storeid) {
		Vector<Bicycle> list = new Vector<Bicycle>();	
		if(DB.openConection()) {
			String query = "SELECT * FROM xedap WHERE xedap.storeid =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, storeid);
				
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					Bicycle bike = new Bicycle();
					bike.setId(rs.getString("bikeid"));
					bike.setName(rs.getString("name"));
					bike.setType(rs.getString("type"));
					bike.setPricePerH(rs.getInt("priceh"));
					bike.setStatus(rs.getString("status"));
					
					list.add(bike);
			}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
		
}
