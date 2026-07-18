package models;

import java.util.concurrent.atomic.AtomicBoolean;

import state.State;
import DTO.ChangeATMStateDTO;
import backend.Backend;

public class ATM {
    private final int atmId;
    private final Backend backend;
    private final AtomicBoolean transactionInProgress = new AtomicBoolean(false);
    private State state;
    private int thresholdAmount;

    // Builder Design Pattern
    public ATM(int atmId, Backend backend, int thresholdAmount) {
        this.atmId = atmId;
        this.thresholdAmount = thresholdAmount;
        this.backend = backend;
    }

    public int getATMId() {
        return atmId;
    }

    public State getState() {
        return state;
    }

    public int getThresholdAmount() {
        return thresholdAmount;
    }

    public void setState(State newState) {
        if(newState == null) {
            throw new IllegalArgumentException("State cannot be null.");
        }
        boolean isSuccess = backend.changeATMState(new ChangeATMStateDTO(newState.getATMState()));
        if(!isSuccess) {
            throw new IllegalStateException("There was a problem while transition from one state to another.");
        }
        state = newState;
    }

    public void setThresholdAmount(int thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public boolean tryBeginTransaction() {
        return transactionInProgress.compareAndSet(false, true);
    }

    public void endTransaction() {
        transactionInProgress.set(false);
    }
}
