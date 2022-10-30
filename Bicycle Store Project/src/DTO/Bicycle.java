package DTO;

public class Bicycle {
    private String id;
    private String type;
    private String name;
    private Double pricePerH;
    private String status;

    public Bicycle(String id, String type, String name, Double pricePerHour, String status) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.pricePerH = pricePerH;
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

    public Double getPricePerHour() {
        return pricePerH;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerH = pricePerHour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
