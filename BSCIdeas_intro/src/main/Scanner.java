package main;

public class Scanner {

    public void loopUSerInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            if (!Parser.parseInput(input)) {
                break;
            }

        }

    }

}
