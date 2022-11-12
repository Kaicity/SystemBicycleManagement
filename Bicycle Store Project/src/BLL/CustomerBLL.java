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
		if(cusDAL.addCustomer(cus)) {
			return "success";
		}
		return "failed";
	}
	
	public String checkCus(String cccd) {
		if(cusDAL.checkCuS(cccd)) {
			return "exists";
		}
		else
			return "no exists";
	}
	
	
}
