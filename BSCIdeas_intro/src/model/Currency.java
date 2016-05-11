package model;

import java.util.HashSet;
import java.util.Set;

public class Currency {

    private final String currencyCode;
    private double exchangeRate;
    private static final Set<Currency> currencies = new HashSet<>();

    static {
        currencies.add(new Currency("AUD", 0.73));
        currencies.add(new Currency("CAD", 0.77));
        currencies.add(new Currency("CHF", 1.02));
        currencies.add(new Currency("CZK", 0.04));
        currencies.add(new Currency("DKK", 0.15));
        currencies.add(new Currency("EUR", 1.13));
        currencies.add(new Currency("GBP", 1.44));
        currencies.add(new Currency("HKD", 0.12));
        currencies.add(new Currency("HUF", 0.00362));
        currencies.add(new Currency("JPY", 0.00915));
        currencies.add(new Currency("NOK", 0.12));
        currencies.add(new Currency("NZD", 0.67));
        currencies.add(new Currency("PLN", 0.25));
        currencies.add(new Currency("SEK", 0.12));
        currencies.add(new Currency("SGD", 0.73));
        currencies.add(new Currency("USD", 1));
        currencies.add(new Currency("ZAR", 0.066));
    }

    public Currency(String currencyCode, double exchangeRate) {
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

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
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
