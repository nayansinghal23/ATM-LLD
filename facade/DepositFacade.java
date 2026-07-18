package facade;
import state.InputProvider;
import state.TransactionContext;

public class DepositFacade implements Facade {

    private final TransactionContext context;

    public DepositFacade(TransactionContext context) {
        this.context = context;
    }

    @Override
    public void execute(InputProvider inputProvider) {
        // TODO: drive a deposit-specific State chain (e.g. CardAndPinReadingState ->
        // EnterDepositAmountState -> CreditAccountState -> EjectCardState) once those
        // states exist. Structurally the same shape as WithdrawalFacade.execute().
        throw new UnsupportedOperationException("Deposit flow not yet implemented.");
    }
}
