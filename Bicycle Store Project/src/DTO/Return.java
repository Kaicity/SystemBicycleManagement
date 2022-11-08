package src.DTO;

public class Return {
    private Rent rent;
    private int returnDays;
    private Double violation;

    public Return(Rent rent, int returnDays, Double violation) {
        this.rent = rent;
        this.returnDays = returnDays;
        this.violation = 1.0;
    }

    public Return() {

    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public int getReturnDays() {
        return returnDays;
    }

    public void setReturnDays(int returnDays) {
        this.returnDays = returnDays;
    }

    public Double getViolation() {
        return violation;
    }

    public void setViolation(Double violation) {
        this.violation = violation;
    }

    public Double returnDeposit(){
        return rent.getDeposit();
    }

    public Double HandlingViolation(){
        // compare date violations
        return violation * returnDays * 100;
    }
}
