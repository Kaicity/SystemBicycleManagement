package src.DAL;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import src.DTO.Bicycle;


public class BicycleDAL {
	ConnectDatabase DB = new ConnectDatabase();
	
	//Lay du lieu tu danh sach xe dap
	public Vector<Bicycle> getBicycleList(String getStoreId){
		Vector<Bicycle> list = new Vector<Bicycle>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM `xedap` WHERE `xedap`.`storeid` = '"+getStoreId+"'";
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
	
	//Them xe dap
	public Boolean addBicycle(Bicycle bike) {
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO xedap VALUES(?,?,?,?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, bike.getId());
				pr.setString(2, bike.getName());
				pr.setString(3, bike.getType());
				pr.setString(4, bike.getStoreId());
				pr.setInt(5, bike.getPricePerH());
				pr.setString(6, bike.getStatus());
			
				
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
	
	//kiem tra id id xe dap
	public Boolean checkId(String bikeId) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "SELECT * FROM xedap WHERE bikeid =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, bikeId);
				
				ResultSet rs = pr.executeQuery();
				result = rs.next();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// sua xe dap 
	public boolean editBicycle(Bicycle bike) {
		boolean result = false;
		if(DB.openConection()) {
			String sql = "UPDATE xedap SET name =?, type =?, storeid =?, priceh =?, status =? WHERE bikeid =?";
			try {
				PreparedStatement pr = DB.con.prepareStatement(sql);
				pr.setString(1, bike.getName());
				pr.setString(2, bike.getType());
				pr.setString(3, bike.getStoreId());
				pr.setInt(4, bike.getPricePerH());
				pr.setString(5, bike.getStatus());
				
				//where
				pr.setString(6, bike.getId());
				if(pr.executeUpdate() >= 0) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.closeConection();
			}
		}
		return result;
	}
	
	//Xoa xe dap khoi danh sach
	public Boolean RemoveBicycle(String id) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "DELETE FROM xedap WHERE bikeid =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, id);
				if(pr.executeUpdate() >= 0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//Tiem kiem xe dap trong danh sach tra ve mot object
	public Bicycle SeachBicycle(String id) {
		Boolean result = false;
		Bicycle object = new Bicycle();
		if(DB.openConection()) {
			String query = "SELECT * FROM xedap WHERE bikeid =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, id);
				
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					object.setId(rs.getString("bikeid"));
					object.setName(rs.getString("name"));
					object.setType(rs.getString("type"));
					object.setStoreId(rs.getString("storeid"));
					object.setPricePerH(rs.getInt("priceh"));
					object.setStatus(rs.getString("status"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
	
	//tiem kiem 1 danh sach xe dap = ten
	public Vector<Bicycle> SeachBicycleByName (String id) {
		Boolean result = false;
		Vector<Bicycle> list = new Vector<Bicycle>();
		if(DB.openConection()) {
			String query = "SELECT * FROM bicycle WHERE id =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, id);
				
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
