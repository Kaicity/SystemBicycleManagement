package DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Rent{
    private Store store;
    private Customer customer;
    private int qualityRentDays;
    private Double deposit;

	private ArrayList<Bicycle> bikelist = new ArrayList<Bicycle>();
    

    public Rent(Store store, Customer customer, int qualityRentDays, Double deposit ) {
        this.store = store;
        this.customer = customer;
        this.qualityRentDays = qualityRentDays;
        this.deposit = deposit;
       
    }

    public Rent() {
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

    public int getQualityRentNumber() {
        return qualityRentDays;
    }

    public void setQualityRentNumber(int qualityRentNumber) {
        this.qualityRentDays = qualityRentNumber;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double RentPayment(){
        return (store.getBicycle().getPricePerHour() * qualityRentDays) + deposit;
    }
    
    public Double getTotal() {
    	Double total = 0.0;
    	for (int i = 0; i < bikelist.size() ; i ++) {
    		total += bikelist.get(i).getPricePerHour() * this.qualityRentDays ;
    	}
    	return total + deposit;
     }
    
}
	