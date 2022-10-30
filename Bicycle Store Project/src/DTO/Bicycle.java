package DTO;

public class Bicycle {
	private Store st;
    private String id;
    private String type;
    private String name;
    private Double pricePerH;
    private String status;

    public Bicycle(Store st, String id, String type, String name, Double pricePerH, String status) {
    	this.st = st;
        this.id = id;
        this.type = type;
        this.name = name;
        this.pricePerH = pricePerH;
        this.status = status;
    }

    public Bicycle() {
    }
    
    

    public Store getSt() {
		return st;
	}

	public void setSt(Store st) {
		this.st = st;
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
