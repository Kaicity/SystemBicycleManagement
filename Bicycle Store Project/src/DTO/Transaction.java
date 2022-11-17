package src.DTO;

import java.util.Date;

public class Transaction {
	
    
    private String id;
    private String idBicycle;
    private String Status;
    private String rentDate;
    private String returnDate;
    
    public  Transaction(String id,String idBicycle,String Status,String rentDate,String returnDate)
    {
    	this.id = id;
    	this.idBicycle=idBicycle;
    	this.Status=Status;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
    	
    }
    public  Transaction() 
    {
    
    }
    public String getId() {
		return id;
	}
    public String getIdBicycle() {
		return idBicycle;
	}
    public String getStatus() {
		return Status;
	}
    public String getRentDate() {
		return rentDate;
	}
    public String getReturnDate() {
		return returnDate;
	}
    
    public void setId(String id) {
		this.id = id;
	}
    public void setIdBicycle(String idBicycle) {
		this.idBicycle = idBicycle;
	}
    public void setStatus(String status) {
		Status = status;
	}
    public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
    public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
    

}
