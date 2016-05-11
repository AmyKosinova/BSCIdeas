package model;

import java.util.HashSet;
import java.util.Set;

public class Currency {

    private final String currencyCode;
    private double echangeRate;
    private static final Set<Currency> currencies = new HashSet<>();

    static {
        currencies.add(new Currency("USD", 1));
        currencies.add(new Currency("HKD", 0.13)); //1HKD = 0.13USD => input*exchange = USD
        currencies.add(new Currency("RMB", 0.15));
        currencies.add(new Currency("NZD", 0.67));
        currencies.add(new Currency("GBP", 1.44));
        currencies.add(new Currency("EUR", 1.14));
        currencies.add(new Currency("CZK", 0.042));
    }

    public Currency(String currencyCode, double echangeRate) {
        this.currencyCode = currencyCode;
        this.echangeRate = echangeRate;
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

    public double getEchangeRate() {
        return echangeRate;
    }

    public void setEchangeRate(double echangeRate) {
        this.echangeRate = echangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public String toString() {
        return getCurrencyCode();
    }

}
