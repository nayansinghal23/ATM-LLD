package state;

import DTO.InitializeTransactionDTO;
import emums.ATMState;

public class ReadyForTransactionState implements State {
    @Override
    public ATMState getATMState() {
        return ATMState.READY_FOR_TRANSACTION;
    }

    @Override
    public void execute(TransactionContext context, InputProvider inputProvider) {
        System.out.println("Initializing a new transaction...");
        int atmId = context.getATM().getATMId();
        InitializeTransactionDTO dto = new InitializeTransactionDTO(atmId);
        
        int transactionId = context.getBackend().createTransaction(dto);
        
        if(transactionId <= 0) {
            throw new IllegalStateException("Transaction ID should be greater than 0.");
        }
        context.setTransactionId(transactionId);
        System.out.println("Transaction initialized with " + transactionId + " transaction ID.");
        context.getATM().setState(new CardAndPinReadingState());
    }
}
