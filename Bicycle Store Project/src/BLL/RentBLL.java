package src.BLL;

import java.util.Vector;



import src.DAL.BicycleDAL;
import src.DAL.CustomerDAL;
import src.DAL.DetailRentBikeDAL;
import src.DAL.StoreDAL;
import src.DTO.Bicycle;
import src.DTO.Customer;
import src.DTO.Rent;
import src.DTO.Store;

public class RentBLL {
	CustomerDAL cusDAl = new CustomerDAL();
	DetailRentBikeDAL rentDAL = new DetailRentBikeDAL();
	StoreDAL storeDAL = new StoreDAL();
	BicycleBLL bikeBll = new BicycleBLL();
	BicycleDAL bikeDAL = new BicycleDAL();
	
	
	
	public Vector<Bicycle> getBicyclesList(String getStoreId){
		return bikeBll.getBicyclesList(getStoreId);
	}
	
	public Vector<Store> getStoreList(){
		return storeDAL.getStoreList();
	}
	
	public String add_GetInformationCustomer(Customer cus) {
		if(cusDAl.checkCccd(cus.getCccd())) {
			return "Thuê ngay";
		}
		if(cusDAl.addCustomer(cus)){
			return "Thuê lần đầu";
		}
		return "failed";
	}
	
	public String createInvoice(Rent rentbike, String cccd, String bikeid) {
		if(rentDAL.checkHdonId(rentbike.getId())) {
			return "exist";
		}
		if(!(cusDAl.checkCccd(cccd))) {
			return "not exist " + cccd ;
		}
		if(!(bikeDAL.checkId(bikeid))) {
			return "not exist " + bikeid;
		}
		if(rentDAL.orderBike(rentbike)) {
			return "Thuê thành công";
		}
		
		return "Thuê thất bại";
	}
	public String updateStatus(String bikeid) {
		if(rentDAL.updateStatusBike(bikeid)) {
			return "success";
		}
		return "failed";
	}
}
