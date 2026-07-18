package facade;
import models.ATM;
import state.InputProvider;
import state.ReadyForTransactionState;
import state.State;
import state.TransactionContext;

public class WithdrawalFacade implements Facade {

    private final TransactionContext context;

    public WithdrawalFacade(TransactionContext context) {
        this.context = context;
    }

    @Override
    public void execute(InputProvider inputProvider) {
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
            } else {
                System.out.println("Transaction Successful");
            }
        } finally {
            atm.endTransaction();
        }
    }
}
