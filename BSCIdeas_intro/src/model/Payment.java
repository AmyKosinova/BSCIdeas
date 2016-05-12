package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {

    private final BigDecimal amount;
    private final Currency currency;

    public Payment(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getStandardCurrencyValue() {
        return amount.multiply(currency.getExchangeRate());
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return currency + " " + String.format("%.2f", amount);
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
