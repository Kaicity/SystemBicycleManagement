package DTO;

public class Store {
    private Account account;
    private Bicycle bicycle;
    private String id;
    private String address;
    private String phone;
    private String fax;

    public Store(Account account, Bicycle bicycle, String id, String address, String phone, String fax) {
        this.account = account;
        this.bicycle = bicycle;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
    }

    public Store(String id, String address, String phone, String fax) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
    }

    public Store() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
