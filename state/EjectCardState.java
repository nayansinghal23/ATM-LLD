package state;

import emums.ATMState;

public class EjectCardState implements State {
    @Override
    public ATMState getATMState() {
        return ATMState.EJECT_CARD;
    }
    
    @Override
    public void execute(TransactionContext context) {
        System.out.println("Take your card back.");
        context.getATM().setState(new ReadyForTransactionState());
    }
}
