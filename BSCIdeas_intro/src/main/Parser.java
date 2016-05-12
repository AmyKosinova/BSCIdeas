package main;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import model.Currency;
import model.Payment;
import model.actions.Action;
import model.actions.AddPayment;
import model.actions.Executor;
import model.actions.LoadData;

public class Parser {

    private static final String ADD_PAYMENT_RX = "(\\w{3})\\ {0,1}(-{0,1}\\d+(\\.|\\,){0,1}\\d*)";
    private static final String LOAD_FILE_RX = "load\\ {1}(.*)";
    private static final String EXIT_RX = "quit";
    private static final String BLANK_RX = "^$";

    public static boolean parseInput(String input) {
        Action runAction = null;
        if (input.matches(ADD_PAYMENT_RX)) {
            runAction = new AddPayment(
                    new BigDecimal(input.replaceAll(ADD_PAYMENT_RX, "$2").replace(",", ".")),
                    Currency.getCurrency(input.replaceAll(ADD_PAYMENT_RX, "$1")));
        } else if (input.matches(LOAD_FILE_RX)) {
            runAction = new LoadData(new File(input.replaceAll(LOAD_FILE_RX, "$1")));
        } else if (input.matches(EXIT_RX)) {
            System.out.println("exiting applicaton");
            return false;
        } else if (input.matches(BLANK_RX)) {
            //do nothing
        } else {
            System.out.println("> " + input);
            printSupportedCommands();
        }
        Executor.getInstance().execute(runAction);
        return true;
    }

    public static Payment parseFileInput(String input) {
        if (input.matches(ADD_PAYMENT_RX)) {
            return new Payment(
                    new BigDecimal(input.replaceAll(ADD_PAYMENT_RX, "$2").replace(",", ".")),
                    Currency.getCurrency(input.replaceAll(ADD_PAYMENT_RX, "$1")));
        }
        return null;
    }

    private static void printSupportedCommands() {
        System.out.println("Command not recognized.\n"
                + "please use only following inputs\n"
                + "3 letter currency, space, amount to add payment. Ex: USD 100\n"
                + "load <file_path> to load payments file\n"
                + "quit to exit program");
    }

}
