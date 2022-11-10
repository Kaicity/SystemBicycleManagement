package src.BLL;

import java.util.Vector;



import src.DAL.BicycleDAL;
import src.DAL.StoreDAL;
import src.DTO.Bicycle;
import src.DTO.Store;

public class BicycleBLL {
	
	BicycleDAL bikeBLL = new BicycleDAL();
	StoreDAL stoBLL = new StoreDAL();
	
	public Vector<Bicycle> getBicyclesList(String storeid){
		return bikeBLL.getBicycleList(storeid);
	}
	
	public Vector<Store> getStoreList(){
		return stoBLL.getStoreList();
	}
	
	public String addbikeBLL(Bicycle b) {
		if(bikeBLL.checkId(b.getId())) {
			return "exist" + " "+b.getId();
		}
		if(!(stoBLL.checkStoreId(b.getStoreId()))) {
			return "Store not exist";
		}
	    if(stoBLL.checkStoreId(b.getStoreId())) {
	    	if(bikeBLL.addBicycle(b)) {
		    	return "success";
		    }
	    }
	    return "failed";
	}
	
	public String delbikeBLL(String bikeid) {
		if(bikeBLL.RemoveBicycle(bikeid)) {
			return "success";
		}
		return "failed";
	}
	
	public String editbikeBLL(Bicycle bike) {
		if(bikeBLL.editBicycle(bike)) {
			return "success";
		}
		return "failed";
	}
	
	public Bicycle searchbikeBLLID(String id){
		return bikeBLL.SeachBicycle(id);
	}
	
	public Vector<Bicycle> searchbikeBLLName(String name){
		return bikeBLL.SeachBicycleByName(name);
	}
	
}
