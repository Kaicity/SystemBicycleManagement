package src.BLL;

import java.util.Vector;

import src.DAL.QuanLyDAL;
import src.DTO.Rent;

public class QuanLyBLL {
	
	QuanLyDAL quanlyDal = new QuanLyDAL();
	
	public Boolean checkHoaDon(String hdid) {
		return quanlyDal.checkHoaDon(hdid);
	}
	
	public Vector<Rent> allHoaDonList(){
		return quanlyDal.getAllHoaDonlist();
	}
	
	public Vector<Rent> getAllHoaDonListByStatus(String status){
		return quanlyDal.getHoaDonListByStatus(status);
	}
	
	public Rent getHoaDonListById(String id) {
		return quanlyDal.getHoaDonListById(id);
	}
	
	public String editHoaDon(Rent hoadon) {
		if(quanlyDal.editHoaDon(hoadon)) {
			return "success";
		}
		else
			return "fail";
	}
	
	public Vector<Rent> getHoaDonListByCccdAndStatus(String cccd, String status){
		return quanlyDal.getHoaDonListByCccdAndStatus(cccd, status);
	}
	
	public Vector<Rent> getHoaDonListByCccd(String cccd){
		return quanlyDal.getHoaDonListByCccd(cccd);
	}
	
	public String huyHoaDon(Rent hoadon) {
		if(quanlyDal.huyHoaDon(hoadon)) {
			return "success";
		}
		else
			return "fail";
	}
	
	public String hoanthanhHoaDon(Rent hoadon) {
		if(quanlyDal.hoanthanhHoaDon(hoadon)) {
			return "success";
		}
		else
			return "fail";
	}

}
