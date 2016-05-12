package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Payment {

    private final BigDecimal amount;
    private final Currency currency;

    public Payment(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(2,RoundingMode.HALF_UP);
        this.currency = currency;
    }

    public BigDecimal getStandardCurrencyValue() {
        return amount.multiply(currency.getExchangeRate()).setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return currency + " " + amount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.amount);
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
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        return Objects.equals(this.currency, other.currency);
    }

}
