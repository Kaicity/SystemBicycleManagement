package src.DTO;

import java.util.Date;

public class TransactionDTO {
	
    
    private String id;
    private String idBicycle;
    private String Status;
    private Date rentDate;
    private Date returnDate;
    
    public  TransactionDTO(String id,String idBicycle,String Status,Date rentDate,Date returnDate)
    {
    	this.id = id;
    	this.idBicycle=idBicycle;
    	this.Status=Status;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
    	
    }
    public  TransactionDTO() 
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
    public Date getRentDate() {
		return rentDate;
	}
    public Date getReturnDate() {
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
    public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
    public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
    

}
