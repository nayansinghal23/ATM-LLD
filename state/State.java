package state;

import emums.ATMState;

public interface State {
    ATMState getATMState();
    void execute(TransactionContext context, InputProvider inputProvider);
}
