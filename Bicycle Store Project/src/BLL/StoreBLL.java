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
			return "exist";
		}
		if(sto.addStore(st)) {
			return "success";
		}
		return "failed";
	}
	
	public String editStore(Store st) {
		if(sto.editStore(st)) {
			return "sucess";
		}
		else
			return "failed";
	}
	
	public String delstore(String storeid) {
		if(sto.RemoveStore(storeid)) {
			return "sucess";
		}
		else
			return "failed";
	}
	
	//seach 
	public Vector<Store> searchstoName(){
		return sto.getStoreList();
	}
}
