package DTO;

public class Store {
    private String id;
    private String name;
    private String address;
    private String tax;
	public Store(String id, String name, String address, String tax) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tax = tax;
	}

    public Store() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
    
    
    
}
