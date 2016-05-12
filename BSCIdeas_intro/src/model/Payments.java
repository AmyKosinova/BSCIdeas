package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Payments implements Serializable {

    private static Payments instance;
    private List<Payment> allPayments;

    public static Payments getInstance() {
        if (instance == null) {
            instance = new Payments();
        }
        return instance;
    }

    private Payments() {
        allPayments = new ArrayList<>();
    }

    public void addRecord(Payment newPayment) {
        getAllPayments().add(newPayment);
    }

    public List<Payment> getAllPayments() {
        return allPayments;
    }

    public void setAllPayments(List<Payment> allPayments) {
        this.allPayments = allPayments;
    }

    public void prinPayments() {
        System.out.println("\tStored payments");
        if (!getAllPayments().isEmpty()) {
            for (Payment payment : getAllPayments()) {
                if (payment.getAmount() != 0) {
                    System.out.println("\t" + payment + " (USD "+String.format("%.2f",payment.getStandardCurrencyValue())+")");
                }
            }
        } else {
            System.out.println("\tNo stored payments");
        }
        System.out.println("----------------------------");
    }

}
