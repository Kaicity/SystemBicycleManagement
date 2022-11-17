package src.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import src.DTO.Bicycle;
import src.DTO.Customer;
import src.DTO.Rent;

public class QuanLyDAL {
	 ConnectDatabase DB = new ConnectDatabase();
	 
	 // xuat tat ca hoa don 
	 public Vector<Rent> getAllHoaDonlist() {
			Vector<Rent> list = new Vector<Rent>();
			
			if(DB.openConection()) {
				String query = "SELECT * FROM `hoadon`" ;
				try {
					PreparedStatement pr = DB.con.prepareStatement(query);
					ResultSet rs = pr.executeQuery(query);
					while(rs.next()) {
						Rent rt = new Rent();
						rt.setId(rs.getString("hdid"));
						rt.setCustomer(rs.getString("cccd"));
						rt.setBicycle(rs.getString("bikeid"));
						rt.setRentDate(rs.getString("rentDate"));
						rt.setReturnDate(rs.getString("returndate"));
						rt.setstatus(rs.getString("note"));
						
						list.add(rt);
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
	 
	 	//xuat tat ca hoa don co trinh trang = ?
		public Vector<Rent> getHoaDonListByStatus(String status) {
			Vector<Rent> list = new Vector<Rent>();
			
			if(DB.openConection()) {
				String query = "SELECT * FROM `hoadon` WHERE `note` LIKE '?'" ;
				try {
					PreparedStatement pr = DB.con.prepareStatement(query);
					pr.setString(1, status);
					ResultSet rs = pr.executeQuery(query);
				
					
					while(rs.next()) {
						Rent rt = new Rent();
						rt.setId(rs.getString("hdid"));
						rt.setCustomer(rs.getString("cccd"));
						rt.setBicycle(rs.getString("bikeid"));
						rt.setRentDate(rs.getString("date"));
						rt.setReturnDate(rs.getString("returndate"));
						rt.setstatus(rs.getString("note"));
						
						list.add(rt);
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
		
		//tim hoa don co hdid = ?
		public Rent getHoaDonListById(String id) {
			Rent rt = new Rent();
			if(DB.openConection()) {
				String query = "SELECT * FROM `hoadon` WHERE `hdid` = '?'" ;
				try {
					PreparedStatement pr = DB.con.prepareStatement(query);
					pr.setString(1, id);
					ResultSet rs = pr.executeQuery(query);
					rt.setId(rs.getString("hdid"));
					rt.setCustomer(rs.getString("cccd"));
					rt.setBicycle(rs.getString("bikeid"));
					rt.setRentDate(rs.getString("date"));
					rt.setReturnDate(rs.getString("returndate"));
					rt.setstatus(rs.getString("note"));
				}catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					DB.closeConection();
				}
			}
			return rt;
		}
		
		//update hoadon
		public boolean editHoaDon(Rent hoadon) {
			boolean result = false;
			if(DB.openConection()) {
				String sql = " UPDATE `hoadon` SET `returndate` = '?', `note` = '?' WHERE `hoadon`.`hdid` = ? ";
				try {
					PreparedStatement pr = DB.con.prepareStatement(sql);
					pr.setString(1, hoadon.getReturnDate());
					pr.setString(2, hoadon.getStatus());
				    //where
					pr.setString(3, hoadon.getId());
					
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
		
		// xuat danh sach hoa don co ma khach hang = ? va trang thai + ?
		public Vector<Rent> getHoaDonListByCccdAndStatus(String id, String status) {
			Vector<Rent> list = new Vector<Rent>();
			if(DB.openConection()) {
				String query = "SELECT * FROM `hoadon` WHERE `cccd` = '?' AND `note` LIKE '?'" ;
				try {
					PreparedStatement pr = DB.con.prepareStatement(query);
					pr.setString(1, id);
					pr.setString(2, status);
					ResultSet rs = pr.executeQuery(query);
					while(rs.next()) {
						Rent rt = new Rent();
						rt.setId(rs.getString("hdid"));
						rt.setCustomer(rs.getString("cccd"));
						rt.setBicycle(rs.getString("bikeid"));
						rt.setRentDate(rs.getString("date"));
						rt.setReturnDate(rs.getString("returndate"));
						rt.setstatus(rs.getString("note"));
						
						list.add(rt);
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
		
		// xuat danh sach hoa don co ma khach dang = ?
		public Vector<Rent> getHoaDonListByCccd(String id) {
			Vector<Rent> list = new Vector<Rent>();
			if(DB.openConection()) {
				String query = "SELECT * FROM `hoadon` WHERE `cccd` = '?'" ;
				try {
					PreparedStatement pr = DB.con.prepareStatement(query);
					pr.setString(1, id);
					ResultSet rs = pr.executeQuery(query);
					while(rs.next()) {
						Rent rt = new Rent();
						rt.setId(rs.getString("hdid"));
						rt.setCustomer(rs.getString("cccd"));
						rt.setBicycle(rs.getString("bikeid"));
						rt.setRentDate(rs.getString("date"));
						rt.setReturnDate(rs.getString("returndate"));
						rt.setstatus(rs.getString("note"));
						
						list.add(rt);
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
		
		//huy thue xe
		public boolean huyHoaDon(Rent hoadon) {
			boolean result = false;
			if(DB.openConection()) {
				String sql = " UPDATE `hoadon` SET `returndate` = '?', `note` = '?' WHERE `hoadon`.`hdid` = ? ";
				try {
					PreparedStatement pr = DB.con.prepareStatement(sql);
					pr.setString(1, hoadon.getReturnDate());
					pr.setString(2, "Đã Hủy");
				    //where
					pr.setString(3, hoadon.getId());
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
		
		//tra xe
		public boolean hoanthanhHoaDon(Rent hoadon) {
			boolean result = false;
			if(DB.openConection()) {
				String sql = " UPDATE `hoadon` SET `returndate` = '?', `note` = '?' WHERE `hoadon`.`hdid` = ? ";
				try {
					PreparedStatement pr = DB.con.prepareStatement(sql);
					pr.setString(1, hoadon.getReturnDate());
					pr.setString(2, "Đã Trả");
				    //where
					pr.setString(3, hoadon.getId());
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
		
		
		

}
