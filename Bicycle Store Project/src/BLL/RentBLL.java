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
	
	public Customer getInformationCustomer(String cccd) {
		return cusDAl.SeachCustomer(cccd);
	}
	
	public int getNextHdid() {
		return rentDAL.nextId();
	}
	
	public String addHoadon(Rent rt) {
		if(rentDAL.orderBike(rt)) {
			return "success";
		}
		else return "false";
	}
	
}
