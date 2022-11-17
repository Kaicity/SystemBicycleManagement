package src.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Rent{
	
	private String id;
	private int deposit;
    private String rentDate;
    private String returnDate;
	
    private String customer;
    private String bicycle;
    private String status;
    
   
	public Rent(String id, int deposit, String rentDate, String returnDate, String customer, String bicycle, String status) {
		super();
		this.id = id;
		this.deposit = deposit;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.customer = customer;
		this.bicycle = bicycle;
		this.status = status;
	}
	
	
	public Rent(String id, int deposit, String rentDate, String returnDate, String customer, String bicycle) {
		super();
		this.id = id;
		this.deposit = deposit;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.customer = customer;
		this.bicycle = bicycle;
	}

	public Rent() {}
	
	
	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getBicycle() {
		return bicycle;
	}

	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public void setstatus(String status) {
		this.status = status;
	}
	public String status() {
		return status;
	}
	
	public int rentPayment(int priceH, int howDay) {
		return (priceH * howDay * 24) + getDeposit() ;
	}
}
	