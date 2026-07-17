import java.util.Date;

import backend.Backend;
import backend.NodeBackendServer;
import models.ATM;
import models.Card;
import state.TransactionContext;

public class Main {
    public static void main(String[] args) {
        Backend backend = new NodeBackendServer();
        ATM atm = new ATM(1, backend, 30000);
        Card card = new Card("Nayan", 1234, 9876, new Date(2025, 12, 31));
    
        TransactionContext context = new TransactionContext(atm, backend, card);
        ATMFacade facade = new ATMFacade();
        facade.withdraw(context);
    }
}

/**
 * What if the backend fails after the user's account is debited but before cash is dispensed?
 * How would you make dispensing idempotent?
 * How would you support multiple transaction types?
 * How would you model hardware failures like a cash jam?
 * How would you prevent two concurrent withdrawals on the same ATM?
 * How would you persist and restore the state machine after a restart?
 */