package model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Currency {

    private final String currencyCode;
    private BigDecimal exchangeRate;
    private static final Set<Currency> currencies = new HashSet<>();

    static {
        currencies.add(new Currency("AUD", new BigDecimal(0.73)));
        currencies.add(new Currency("CAD", new BigDecimal(0.77)));
        currencies.add(new Currency("CHF", new BigDecimal(1.02)));
        currencies.add(new Currency("CZK", new BigDecimal(0.04)));
        currencies.add(new Currency("DKK", new BigDecimal(0.15)));
        currencies.add(new Currency("EUR", new BigDecimal(1.13)));
        currencies.add(new Currency("GBP", new BigDecimal(1.44)));
        currencies.add(new Currency("HKD", new BigDecimal(0.12)));
        currencies.add(new Currency("HUF", new BigDecimal(0.00362)));
        currencies.add(new Currency("JPY", new BigDecimal(0.00915)));
        currencies.add(new Currency("NOK", new BigDecimal(0.12)));
        currencies.add(new Currency("NZD", new BigDecimal(0.67)));
        currencies.add(new Currency("PLN", new BigDecimal(0.25)));
        currencies.add(new Currency("SEK", new BigDecimal(0.12)));
        currencies.add(new Currency("SGD", new BigDecimal(0.73)));
        currencies.add(new Currency("USD", new BigDecimal(1)));
        currencies.add(new Currency("ZAR", new BigDecimal(0.066)));
        currencies.add(new Currency("RMB", new BigDecimal(0.15)));
    }

    public Currency(String currencyCode, BigDecimal exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    public static Currency getCurrency(String currency) {
        if (currency != null) {
            for (Currency cur : currencies) {
                if (currency.equalsIgnoreCase(cur.getCurrencyCode())) {
                    return cur;
                }
            }
        }
        return null;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public String toString() {
        return getCurrencyCode();
    }
}
