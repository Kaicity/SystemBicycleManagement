package src.DAL;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import src.DTO.Bicycle;
import src.DTO.Customer;
import src.DTO.Store;

public class StoreDAL {
   ConnectDatabase DB = new ConnectDatabase();
	
	//Lay du lieu tu danh sach cua hang 
	public Vector<Store> getStoreList(){
		Vector<Store> list = new Vector<Store>();
		
		if(DB.openConection()) {
			String query = "SELECT * FROM cuahang";
			try {
				Statement st = DB.con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
					Store sto = new Store();
					sto.setId(rs.getString("storeid"));
					sto.setName(rs.getString("name"));
					sto.setAddress(rs.getString("address"));
					sto.setFax(rs.getString("fax"));
					sto.setPhone(rs.getString("phone"));
					
					list.add(sto);
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
	public Boolean addStore(Store st) {
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO cuahang VALUES(?,?,?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, st.getId());
				pr.setString(2, st.getName());
				pr.setString(3, st.getAddress());
				pr.setString(4, st.getFax());
				pr.setString(5, st.getPhone());
				
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
	
	//kiem tra id id cua hang 
	public Boolean checkStoreId(String id) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "SELECT * FROM cuahang WHERE storeid =?";
			
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
	
	
	// sua cua hang co id la cmnd
		public boolean editStore(Store st) {
			boolean result = false;
			if(DB.openConection()) {
				String sql = "UPDATE cuahang name =?, address =?, fax =?, phone =? WHERE storeid =?";
				try {
					PreparedStatement pr = DB.con.prepareStatement(sql);
					pr.setString(1, st.getName());
					pr.setString(2, st.getAddress());
					pr.setString(3, st.getFax());
					pr.setString(4, st.getPhone());
					pr.setString(5, st.getId());
					
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
		
		
	//Xoa cua hang khoi danh sach
	public Boolean RemoveStore(String id) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "DELETE FROM cuahang WHERE storeid =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
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
	
}
