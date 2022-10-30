package DTO;

public class Customer {
    private String cccd;
    private String name;
    private String phone;
    
	public Customer(String cccd, String name, String phone) {
		this.cccd = cccd;
		this.name = name;
		this.phone = phone;
	}
	
	public Customer() {}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
