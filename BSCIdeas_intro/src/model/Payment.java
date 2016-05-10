package model;

public class Payment {

    private final double ammount;
    private final String currency;

    public Payment(double ammount, String currency) {
        this.ammount = ammount;
        this.currency = currency;
    }

    public double getAmmount() {
        return ammount;
    }

    public String getCurrency() {
        return currency;
    }
    
    @Override
    public String toString() {
        return currency + " " + ammount;
    }

}
