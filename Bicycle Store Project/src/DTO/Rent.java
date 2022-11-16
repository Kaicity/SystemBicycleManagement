package src.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Rent{
	
    private Customer customer;
    private Bicycle bicycle;
    private String store;
    
    private String id;
    private int deposit;
    private Date rentDate;
    private Date returnDate;
    
    
	public Rent(Customer customer, Bicycle bicycle, String store, String id, int deposit, Date rentDate,
			Date returnDate) {
		super();
		this.customer = customer;
		this.bicycle = bicycle;
		this.store = store;
		this.id = id;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}
	
	
	public Rent(Bicycle bicycle, String id) {
		super();
		this.bicycle = bicycle;
		this.id = id;
	}


	public Rent() {}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
	
	public int rentPayment(int priceH, int deposit, int day) {
		return priceH + deposit * day * 24;
	}
	
}
	