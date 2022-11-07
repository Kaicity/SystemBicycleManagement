package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DTO.Bicycle;
import DTO.Store;

public class StoreDAL {
   ConnectDatabase DB = new ConnectDatabase();
	
	//Lay du lieu tu danh cua hang 
	public Vector<Store> getBicycleList(){
		Vector<Store> list = new Vector<Store>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM store";
			try {
				Statement st = DB.con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
//					Store st = new Store();
//					st.setId(rs.getString("id"));
//					st.setName(rs.getString("tenxedap"));
//					st.setPricePerHour(rs.getDouble("giathue"));
//					st.setStatus(rs.getString("tinhtrang"));
//					st.setType(rs.getString("loaixe"));
//					
//					list.add(bike);
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
	
	//Them cua hang
	public Boolean addBicycle(Store st) {
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO store VALUES(?,?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, st.getId());
				pr.setString(2, st.getName());
				pr.setString(3, st.getAddress());
				pr.setString(4, st.getTax());
				
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
	public Boolean checkId(String id) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "SELECT * FROM store WHERE id =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, id);
				
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
			String query = "DELETE FROM store WHERE id =?";
			
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
			String query = "SELECT * FROM store WHERE id =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, id);
				
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					object.setId(rs.getString("id"));
					object.setName(rs.getString("tencuahang"));
					object.setType(rs.getString("diachi"));
					object.setStatus(rs.getString("tax"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
}