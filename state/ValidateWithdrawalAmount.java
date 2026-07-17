package state;

import DTO.ValidateUserBankAmountDTO;
import emums.ATMState;
import models.ATM;

public class ValidateWithdrawalAmount implements State {
    @Override
    public void execute(TransactionContext context) {
        ATM atm = context.getATM();
        int withdrawalAmount = context.getWithdrawalAmount();

        if(withdrawalAmount <= 0) {
            throw new IllegalStateException("Withdrawal amount should be greater than zero.");
        }

        if(atm.getThresholdAmount() < withdrawalAmount) {
            throw new IllegalStateException("ATM doesn't hold enough money!!!");
        }

        ValidateUserBankAmountDTO dto = new ValidateUserBankAmountDTO(context.getCard(), withdrawalAmount);
        boolean isEnoughMoney = context.getBackend().validateUserBankAmount(dto);

        if(!isEnoughMoney) {
            throw new IllegalStateException("User doesn't hold enough money!!!");
        }

        atm.setState(new CashDispensingState());
    }

    @Override
    public ATMState getATMState() {
        return ATMState.WITHDRAWAL_CHECK;
    }
}
