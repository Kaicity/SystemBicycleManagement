package src.BLL;

import java.util.Vector;



import src.DAL.BicycleDAL;
import src.DTO.Bicycle;

public class BicycleBLL {
	
	BicycleDAL bike = new BicycleDAL();
	
	public Vector<Bicycle> getBicyclesList(){
		return bike.getBicycleList();
	}
	
	public String addBike(Bicycle b) {
		if(bike.checkId(b.getId())) {
			return "exist";
		}
	    if(bike.addBicycle(b)) {
	    	return "success";
	    }
	    return "addthanhcong";
	}
	
	public String delBike(String bikeid) {
		if(bike.RemoveBicycle(bikeid)) {
			return "success";
		}
		else
			return "failed";
	}
	
	public Bicycle searchBikeID(String id){
		return bike.SeachBicycle(id);
	}
	
	public Vector<Bicycle> searchBikeName(String name){
		return bike.SeachBicycleByName(name);
	}
	
}
