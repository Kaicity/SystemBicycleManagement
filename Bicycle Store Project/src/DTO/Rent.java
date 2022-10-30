package DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Rent extends Bicycle{
    private Store store;
    private Customer customer;
    
    private String id;
    private Double deposit;
    private String rentDate;
    private String returnDate;
    private int qualityRentDays;
    
    
    
    
	public Rent(Store st, String id, String type, String name, Double pricePerH, String status, Store store,
			Customer customer, String id2, Double deposit, String rentDate, String returnDate, int qualityRentDays) {
		super(st, id, type, name, pricePerH, status);
		this.store = store;
		this.customer = customer;
		id = id2;
		this.deposit = deposit;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.qualityRentDays = qualityRentDays;
	}
	
	public Rent(Store st, String id, String type, String name, Double pricePerH, String status) {
		super(st, id, type, name, pricePerH, status);
	}
	
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getQualityRentDays() {
		return qualityRentDays;
	}
	public void setQualityRentDays(int qualityRentDays) {
		this.qualityRentDays = qualityRentDays;
	}



//    public Double RentPayment(){
//        return (store.getBicycle().getPricePerHour() * qualityRentDays) + deposit;
//    }
//    
//    public Double getTotal() {
//    	Double total = 0.0;
//    	for (int i = 0; i < bikelist.size() ; i ++) {
//    		total += bikelist.get(i).getPricePerHour() * this.qualityRentDays ;
//    	}
//    	return total + deposit;
//    }
	
}
	