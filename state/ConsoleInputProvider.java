package state;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {

    private final Scanner scanner;

    public ConsoleInputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int readPin() {
        System.out.print("Enter PIN : ");
        return scanner.nextInt();
    }

    @Override
    public int readWithdrawalAmount() {
        System.out.print("Amount : ");
        return scanner.nextInt();
    }
}
