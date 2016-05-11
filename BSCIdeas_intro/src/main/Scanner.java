package main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Scanner {

    public void loopUSerInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input;

        while (true) {
            try {
                input = scanner.nextLine();
                if (!Parser.parseInput(input)) {
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, null, ex);
            }
        }
    }
}
