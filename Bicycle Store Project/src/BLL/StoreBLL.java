package src.BLL;

import java.util.Vector;

import src.DAL.StoreDAL;
import src.DTO.Store;



public class StoreBLL {
     StoreDAL sto = new StoreDAL();
	
	public Vector<Store> getStoreList(){
		return sto.getStoreList();
	}
	
	public String addstore(Store st) {
		if(sto.checkStoreId(st.getId())) {
			return "exist" + " " +st.getId();
		}
		if(sto.addStore(st)) {
			return "success";
		}
		return "failed";
	}
	
	public String editStore(Store st) {
		if(sto.editStore(st)) {
			return "success";
		}
			return "failed";
	}
	
	public String delstore(String id) {
		if(sto.removeStore(id)) {
			return "success";
		}
			return "failed";
	}
	
	
	//seach 
	public Vector<Store> searchstoName(){
		return sto.getStoreList();
	}
}
