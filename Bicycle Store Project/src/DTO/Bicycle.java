package src.DTO;

public class Bicycle {
	

	private String id;
    private String type;
    private String name;
    private int pricePerH;
    private String storeId;
    private String status;
    
    
	public Bicycle(String id, String type, String name, int pricePerH, String storeId, String status) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.pricePerH = pricePerH;
		this.storeId = storeId;
		this.status = status;
	}

    public Bicycle() {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerH() {
		return pricePerH;
	}

	public void setPricePerH(int pricePerH) {
		this.pricePerH = pricePerH;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
