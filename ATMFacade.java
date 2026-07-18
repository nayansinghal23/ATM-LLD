import java.util.Scanner;

import models.ATM;
import state.ConsoleInputProvider;
import state.InputProvider;
import state.ReadyForTransactionState;
import state.State;
import state.TransactionContext;

public class ATMFacade {

    private final InputProvider inputProvider;

    public ATMFacade() {
        this(new ConsoleInputProvider(new Scanner(System.in)));
    }

    public ATMFacade(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void withdraw(TransactionContext context) {
        ATM atm = context.getATM();

        if (!atm.tryBeginTransaction()) {
            System.out.println("ATM is busy with another transaction. Please try again later.");
            return;
        }

        try {
            atm.setState(new ReadyForTransactionState());

            while (!context.isCompleted() && !context.isFailed()) {
                State state = atm.getState();

                try {
                    state.execute(context, inputProvider);
                } catch (Exception e) {
                    context.setFailed(true);
                    context.setFailureReason(e.getMessage());
                }
            }

            if (context.isFailed()) {
                System.out.println("Transaction Failed: " + context.getFailureReason());
            }
            else {
                System.out.println("Transaction Successful");
            }
        } finally {
            atm.endTransaction();
        }
    }
}