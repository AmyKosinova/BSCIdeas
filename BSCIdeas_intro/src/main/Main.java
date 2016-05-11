package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import model.Payments;
import model.actions.Action;
import model.actions.Executor;
import model.actions.LoadData;

public class Main {

    private static final int ANNOUNCE_DELAY = 6 * 1000;

    public static void main(String[] args) {
        setupLogging();

        Timer announceTimer = new Timer(ANNOUNCE_DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Payments.getInstance().prinPayments();
            }
        });
        announceTimer.start();

        if (args.length == 1) {
            File inputFile = new File(args[0]);
            Action loadData = new LoadData(inputFile);
            Executor.getInstance().execute(loadData);
        }

        Scanner scanner = new Scanner();
        scanner.loopUSerInput();

    }

    private static void setupLogging() {
        Logger.getLogger("").getHandlers()[0].setLevel(Level.OFF);
        try {
            Handler handler = new FileHandler("systemLog_%g.xml", 1024, 2, true);
            handler.setLevel(Level.ALL);
            Logger.getLogger("").addHandler(handler);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
