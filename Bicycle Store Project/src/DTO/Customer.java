package DTO;

public class Customer extends Account {
    private String id;
    private String name;
    private String phone;
    private String address;

    public Customer(String id, String name, String phone, String address){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String id, String name, String phone, String address, String username, String password){
        super(username, password);
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer() { }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
