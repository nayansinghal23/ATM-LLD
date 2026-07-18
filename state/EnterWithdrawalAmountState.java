package state;

import emums.ATMState;

public class EnterWithdrawalAmountState implements State {
    @Override
    public void execute(TransactionContext context, InputProvider inputProvider) {
        context.setWithdrawalAmount(inputProvider.readWithdrawalAmount());
        context.getATM().setState(new ValidateWithdrawalAmount());
    }

    @Override
    public ATMState getATMState() {
        return ATMState.AMOUNT_WITHDRAWAL;
    }
}
