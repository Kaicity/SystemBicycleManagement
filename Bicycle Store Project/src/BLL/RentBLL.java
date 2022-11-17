package src.BLL;

import java.util.Vector;


import src.DAL.CustomerDAL;
import src.DAL.RentBikeDAL;
import src.DAL.StoreDAL;
import src.DTO.Bicycle;
import src.DTO.Customer;
import src.DTO.Rent;
import src.DTO.Store;

public class RentBLL {
	CustomerDAL cusDAl = new CustomerDAL();
	RentBikeDAL rentDAL = new RentBikeDAL();
	StoreDAL storeDAL = new StoreDAL();
	BicycleBLL bikeBll = new BicycleBLL();
	
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
	
}
