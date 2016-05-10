package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Parser;

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

    public static void loadData(File loadFile) {
        if (loadFile != null && loadFile.exists()) {
            List<Payment> paymentsToAdd = new ArrayList<>();

            try {
                BufferedReader br = new BufferedReader(new FileReader(loadFile));
                try {
                    Payment addPayment;
                    String line;
                    while (br.ready()) {
                        line = br.readLine();
                        addPayment = Parser.parseFileInput(line);
                        if (addPayment != null) {
                            paymentsToAdd.add(addPayment);
                        } else {
                            Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, "error parsing line, operaton aborted. {0}", line);
                        }
                    }
                    getInstance().getAllPayments().addAll(paymentsToAdd);
                } catch (IOException ex) {
                    Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Data loaded");
        } else {
            System.out.println("File does not exist");
        }
    }

    public void prinPayments() {
        System.out.println("\tStored payments");
        if (!getAllPayments().isEmpty()) {
            for (Payment payment : getAllPayments()) {
                if (payment.getAmmount() != 0) {
                    System.out.println("\t" + payment);
                }
            }
        } else {
            System.out.println("\tNo stored payments");
        }
        System.out.println("----------------------------");
    }

}
