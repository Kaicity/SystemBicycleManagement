package src.DTO;

public class Bicycle {
	private String storeId;
    private String id;
    private String type;
    private String name;
    private Double pricePerH;
    private String status;

    public Bicycle(String storeId, String id, String type, String name, Double pricePerH, String status) {
    	this.storeId = storeId;
        this.id = id;
        this.type = type;
        this.name = name;
        this.pricePerH = pricePerH;
        this.status = status;
    }

    public Bicycle() {
    }
    
    

    public String getStoreID() {
		return storeId;
	}

	public void setSt(String storeId) {
		this.storeId = storeId;
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

   
    public Double getPricePerH() {
		return pricePerH;
	}

	public void setPricePerH(Double pricePerH) {
		this.pricePerH = pricePerH;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
