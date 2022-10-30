package DTO;

public class Store {
    private String id;
    private String address;
    private String phone;
    private String fax;

    public Store(String id, String address, String phone, String fax) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
    }

    public Store() {
       
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
    
    
}
