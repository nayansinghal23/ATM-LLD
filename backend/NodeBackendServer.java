package backend;

import DTO.ATMThresholdAmountDTO;
import DTO.ChangeATMStateDTO;
import DTO.DispenseCashDTO;
import DTO.GetATMStateDTO;
import DTO.InitializeTransactionDTO;
import DTO.ValidateUserBankAmountDTO;
import emums.ATMState;

public class NodeBackendServer implements Backend {
    @Override
    public int createTransaction(InitializeTransactionDTO dto) {
        if(dto.getATMId() <= 0) {
            throw new IllegalStateException("ATM id should be greater than zero.");
        }
        // POST : create a DB autoincremented id corresponding to the ATM user is transacting.
        return (int) (Math.random() * 100000);
    }

    @Override
    public boolean changeATMState(ChangeATMStateDTO dto) {
        // PATCH : change the state of the ATM.
        return true;
    }

    @Override
    public boolean validateUserBankAmount(ValidateUserBankAmountDTO dto) {
        // GET : to verify if the user has enough balance.
        if(dto.getCard() == null) {
            throw new IllegalStateException("Card should not be null.");
        }
        if(dto.getWithdrawalAmount() <= 0) {
            throw new IllegalStateException("Withdrawal amount should be greater than zero.");
        }
        return true;
    }

    @Override
    public boolean dispenseCash(DispenseCashDTO dto) {
        // POST : to dispense the cash, deducts the user's balance and sets the ATM's threshold to current_threshold - dto.getAmount().
        return true;
    }

    @Override
    public int getATMThresholdAmount(ATMThresholdAmountDTO dto) {
        // GET : fetch ATM's threshold amount.
        return 8000;
    }

    @Override
    public ATMState getAtmState(GetATMStateDTO dto) {
        if(dto.getAtmId() <= 0) {
            throw new IllegalStateException("ATM id should be greater than zero.");
        }
        // GET : returns ATM's state
        return ATMState.READY_FOR_TRANSACTION;
    }
}
