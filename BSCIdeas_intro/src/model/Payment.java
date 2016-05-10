package model;

public class Payment {

    private final double ammount;
    private final Currency currency;

    public Payment(double ammount, Currency currency) {
        this.ammount = ammount;
        this.currency = currency;
    }

    public double getAmmount() {
        return ammount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    @Override
    public String toString() {
        return currency + " " + ammount;
    }

}
