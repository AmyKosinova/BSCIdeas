package model.actions;

import model.Currency;
import model.Payment;
import model.Payments;

public class AddPayment implements Action {

    private final double amount;
    private final Currency currency;

    public AddPayment(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public void run() {
        if (currency != null) {
            Payments.getInstance().addRecord(new Payment(amount, currency));
        } else {
            System.err.println("currency not supported");
        }
    }

}
