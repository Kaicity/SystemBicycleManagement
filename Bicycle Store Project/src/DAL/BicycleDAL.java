package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DTO.Bicycle;


public class BicycleDAL {
	ConnectDatabase DB = new ConnectDatabase();
	
	//Lay du lieu tu danh sach xe dap
	public Vector<Bicycle> getBicycleList(){
		Vector<Bicycle> list = new Vector<Bicycle>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM bicycle";
			try {
				Statement st = DB.con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
					Bicycle bike = new Bicycle();
					bike.setId(rs.getString("id"));
					bike.setName(rs.getString("tenxedap"));
					bike.setPricePerHour(rs.getDouble("giathue"));
					bike.setStatus(rs.getString("tinhtrang"));
					bike.setType(rs.getString("loaixe"));
					
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
			String query = "INSERT INTO bicycle VALUES(?,?,?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, bike.getId());
				pr.setString(2, bike.getName());
				pr.setString(3, bike.getType());
				pr.setString(4, bike.getStatus());
				pr.setDouble(5, bike.getPricePerHour());
				
				if(pr.executeUpdate() >= 1) {
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
			String query = "SELECT * FROM bicycle WHERE id =?";
			
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
	//Xoa xe dap  khoi danh sach
	public Boolean RemoveBicycle(String id) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "DELETE FROM bicycle WHERE id =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				if(pr.executeUpdate() >= 1) {
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
			String query = "SELECT * FROM bicycle WHERE id =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, id);
				
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					object.setId(rs.getString("id"));
					object.setName(rs.getString("tenxedap"));
					object.setType(rs.getString("loaixe"));
					object.setStatus(rs.getString("trangthai"));
					object.setPricePerHour(rs.getDouble("giathue"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
}
