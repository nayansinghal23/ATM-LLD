package state;
import backend.Backend;
import models.ATM;
import models.Card;

public class TransactionContext {

    private final ATM atm;
    private final Backend backend;
    private final Card card;

    private int transactionId;
    private int enteredPIN;
    private int withdrawalAmount;

    private boolean completed;
    private boolean failed;

    public TransactionContext(ATM atm, Backend backend, Card card) {
        this.atm = atm;
        this.backend = backend;
        this.card = card;
    }

    public ATM getATM() {
        return atm;
    }

    public Backend getBackend() {
        return backend;
    }

    public Card getCard() {
        return card;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getEnteredPIN() {
        return enteredPIN;
    }

    public int getWithdrawalAmount() {
        return withdrawalAmount;
    }
    
    public boolean isCompleted() {
        return completed;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setEnteredPIN(int enteredPIN) {
        this.enteredPIN = enteredPIN;
    }

    public void setWithdrawalAmount(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }
}