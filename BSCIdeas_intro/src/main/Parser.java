package main;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payment;
import model.Payments;

public class Parser {

    private static final String ADD_PAYMENT_RX = "(\\w{3})\\ {0,1}(-{0,1}\\d+)";
    private static final String LOAD_FILE_RX = "load\\ {1}(.*)";
    private static final String EXIT_RX = "quit";

    public static boolean parseInput(String input) {
        if (input.matches(ADD_PAYMENT_RX)) {
            Payments.getInstance().addRecord(
                    new Payment(
                            Double.parseDouble(input.replaceAll(ADD_PAYMENT_RX, "$2")),
                            input.replaceAll(ADD_PAYMENT_RX, "$1")));
        } else if (input.matches(ADD_PAYMENT_RX)) {
            Payments.loadData(new File(input.replaceAll(LOAD_FILE_RX, "$1")));
        } else if (input.matches(EXIT_RX)) {
            System.out.println("exiting applicaton");
            return false;
        } else {
            System.out.println(input);
            printSupportedCommands();
        }
        return true;
    }

    public static Payment parseFileInput(String input) {
        if (input.matches(ADD_PAYMENT_RX)) {
            return new Payment(
                    Double.parseDouble(input.replaceAll(ADD_PAYMENT_RX, "$2")),
                    input.replaceAll(ADD_PAYMENT_RX, "$1"));
        }
        return null;
    }

    private static void printSupportedCommands() {
        System.out.println("Command not recognized.\n"
                + "please use only following inputs\n"
                + "3 letter currency, space, ammount to add payment. Ex: USD 100\n"
                + "load <file_path> to load payments file\n"
                + "quit to exit program");
    }

}
