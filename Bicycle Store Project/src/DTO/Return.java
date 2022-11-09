package src.DTO;

public class Return {
	
    private Rent rent;
    private int returnDays;
    private int violation;

    public Return(Rent rent, int returnDays, int violation) {
        this.rent = rent;
        this.returnDays = returnDays;
        this.violation = 1;
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

    public int getViolation() {
        return violation;
    }

    public void setViolation(int violation) {
        this.violation = violation;
    }

    public int handlingViolation(){
    
        return (violation * returnDays * 100) - rent.getDeposit();
    }
    
    public int returnDeposit() {
    	return rent.getDeposit() + handlingViolation();
    }
}
