package model;

import java.util.Objects;

public class Payment {

    private final double ammount;
    private final Currency currency;

    public Payment(double ammount, Currency currency) {
        this.ammount = ammount;
        this.currency = currency;
    }

    public double getStandardCurrencyValue() {
        return ammount * currency.getEchangeRate();
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ammount) ^ (Double.doubleToLongBits(this.ammount) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.currency);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (Double.doubleToLongBits(this.ammount) != Double.doubleToLongBits(other.ammount)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        return true;
    }

    
    
}
