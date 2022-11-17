package src.BLL;
import src.DAL.CustomerDAL;
import src.DTO.Customer;

public class CustomerBLL {
	CustomerDAL cusDAL = new CustomerDAL();
	
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
	
}
