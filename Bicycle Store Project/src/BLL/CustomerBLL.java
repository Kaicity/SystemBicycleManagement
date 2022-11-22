package src.BLL;
import java.util.Vector;

import src.DAL.CustomerDAL;
import src.DTO.Customer;

public class CustomerBLL {
	CustomerDAL cusDAL = new CustomerDAL();
	
	public Vector<Customer> getCustomerlist(){
		return cusDAL.getCustomerList();
	}
	public Customer getInformation(String cccd) {
		return cusDAL.SeachCustomer(cccd);
	}
	
	public String addNewCustomer(Customer cus) {
		if(cusDAL.checkCccd(cus.getCccd())) {
			return "exist";
		}
		else
		if(cusDAL.addCustomer(cus)) {
			return "success";
		}
		return "failed";
	}
	
	public String editCustomer(Customer cus) {
		if(cusDAL.editCustomer(cus)) {
			return "success";
		}
		return "failed";
	}
	
	public String removeCustomer(String cusid) {
		if(cusDAL.RemoveCustomer(cusid)) {
			return "success";
		}
		return "failed";
	}
	
	public Boolean checkCCCD(String cccd) {
		return cusDAL.checkCccd(cccd);
	}
	
}
