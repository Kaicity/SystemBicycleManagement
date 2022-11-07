package DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Rent{
	
    private Customer customer;
    private Bicycle bicycle;
    
    private String id;
    private Double deposit;
    private String rentDate;
    private String howDate;
    
	public Rent(Customer customer, Bicycle bicycle, String id, Double deposit, String rentDate,
			String howDate) {
		super();
		this.customer = customer;
		this.bicycle = bicycle;
		this.id = id;
		this.deposit = deposit;
		this.rentDate = rentDate;
		this.howDate = howDate;
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

	public String getHowDate() {
		return howDate;
	}

	public void setHowDate(String howDate) {
		this.howDate = howDate;
	}
	
	
	
	
}
	