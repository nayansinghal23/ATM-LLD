import java.util.Date;

import backend.Backend;
import backend.NodeBackendServer;
import facade.WithdrawalFacade;
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
        facade.transact(new WithdrawalFacade(context));
    }
}

/**
 * How would you support multiple transaction types? - Strategy Design Pattern
 */