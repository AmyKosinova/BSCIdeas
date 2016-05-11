package model.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Parser;
import model.Payment;
import model.Payments;

public class LoadData implements Action {

    private final File loadFile;

    public LoadData(File loadFile) {
        this.loadFile = loadFile;
    }

    @Override
    public void run() {
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
                            if (addPayment.getCurrency() != null) {
                                paymentsToAdd.add(addPayment);
                            } else {
                                Logger.getLogger(Payments.class.getName()).log(Level.WARNING, "error parsing line. Currency not supported. {0}", line);
                                return;
                            }
                        } else {
                            Logger.getLogger(Payments.class.getName()).log(Level.WARNING, "error parsing line, operaton aborted. {0}", line);
                            return;
                        }
                    }
                    Payments.getInstance().getAllPayments().addAll(paymentsToAdd);
                    System.out.println("Data loaded");

                } catch (IOException ex) {
                    Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("File does not exist: " + loadFile.getAbsolutePath());
        }
    }

}
