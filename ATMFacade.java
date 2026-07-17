import java.util.Scanner;

import state.CardAndPinReadingState;
import state.EnterWithdrawalAmountState;
import state.ReadyForTransactionState;
import state.State;
import state.TransactionContext;

public class ATMFacade {

    private final Scanner scanner = new Scanner(System.in);

    public void withdraw(TransactionContext context) {

        context.getATM().setState(
            new ReadyForTransactionState()
        );

        while (!context.isCompleted() && !context.isFailed()) {
            State state = context.getATM().getState();

            if (state instanceof CardAndPinReadingState) {
                System.out.print("Enter PIN : ");
                context.setEnteredPIN(scanner.nextInt());
            }

            if (state instanceof EnterWithdrawalAmountState) {
                System.out.print("Amount : ");
                context.setWithdrawalAmount(scanner.nextInt());
            }

            state.execute(context);
        }

        if (context.isFailed()) {
            System.out.println("Transaction Failed");
        }
        else {
            System.out.println("Transaction Successful");
        }
    }
}