package DTO;

import emums.ATMState;

public class ChangeATMStateDTO {
    private ATMState state;

    public ChangeATMStateDTO(ATMState state) {
        this.state = state;
    }

    public ATMState getState() {
        return state;
    }
}
