package src.DAL;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import src.DTO.Customer;

public class CustomerDAL {
	
	ConnectDatabase DB = new ConnectDatabase();
	//Lay du lieu thu danh sach
	public Vector<Customer> getCustomerList(){
		Vector<Customer> list = new Vector<Customer>();
		if(DB.openConection()) {
			String query = "SELECT * FROM customer";
			try {
				Statement st = DB.con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
					Customer cus = new Customer();
					cus.setCccd(rs.getString("cccd"));
					cus.setName(rs.getString("tenkhachhang"));
					cus.setPhone(rs.getString("sdt"));
					
					list.add(cus);
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
	
	//Them customer
	public Boolean addCustomer(Customer cus) {
		Boolean result = false;
		if(DB.openConection()) {
			String query = "INSERT INTO customer VALUES(?,?,?)";
			PreparedStatement pr;
			
			try {
				pr = DB.con.prepareStatement(query);
				pr.setString(1, cus.getCccd());
				pr.setString(2, cus.getName());
				pr.setString(3, cus.getPhone());
				
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
	
	//kiem tra id cccd khach hang
	public Boolean checkCccd(String cccd) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "SELECT * FROM customer WHERE cccc =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, cccd);
				
				ResultSet rs = pr.executeQuery();
				result = rs.next();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//Xoa khach hang khoi danh sach
	public Boolean RemoveCustomer(String cccd) {
		Boolean result = false;
		
		if(DB.openConection()) {
			String query = "DELETE FROM custome WHERE cccd =?";
			
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
	
	//Tiem kiem khach hang trong danh sach tra ve mot object
	public Customer SeachCustomer(String cccd) {
		Boolean result = false;
		Customer object = new Customer();
		if(DB.openConection()) {
			String query = "SELECT * FROM customer WHERE cccc =?";
			
			try {
				PreparedStatement pr = DB.con.prepareStatement(query);
				pr.setString(1, cccd);
				
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					object.setCccd(rs.getString("cccd"));
					object.setName(rs.getString("tenkhachhang"));
					object.setPhone(rs.getString("sdt"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
}
