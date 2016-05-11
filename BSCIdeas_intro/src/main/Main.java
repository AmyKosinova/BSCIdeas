package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;
import model.Payments;
import model.actions.Action;
import model.actions.Executor;
import model.actions.LoadData;

public class Main {

    private static final int ANNOUNCE_DELAY = 6 * 1000;

    public static void main(String[] args) {

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

}
