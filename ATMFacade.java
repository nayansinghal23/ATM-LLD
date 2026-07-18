import java.util.Scanner;

import facade.Facade;
import state.ConsoleInputProvider;
import state.InputProvider;

public class ATMFacade {

    private final InputProvider inputProvider;

    public ATMFacade() {
        this(new ConsoleInputProvider(new Scanner(System.in)));
    }

    public ATMFacade(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void transact(Facade facade) {
        facade.execute(inputProvider);
    }
}