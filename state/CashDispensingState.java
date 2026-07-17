package state;

import DTO.DispenseCashDTO;
import emums.ATMState;
import models.Card;

public class CashDispensingState implements State {
    @Override
    public ATMState getATMState() {
        return ATMState.CASH_DISPENSE;
    }

    @Override
    public void execute(TransactionContext context) {
        int atmId = context.getATM().getATMId();
        int transactionId = context.getTransactionId();
        int withdrawalAmount = context.getWithdrawalAmount();
        Card card = context.getCard();

        DispenseCashDTO dto = new DispenseCashDTO(atmId, transactionId, withdrawalAmount, card);
        boolean isCashDispensed =  context.getBackend().dispenseCash(dto);

        if(!isCashDispensed) {
            throw new IllegalStateException("There was a problem while dispensing cash!!!");
        }
        System.out.println("Your cash has been dispensed successfully.");

        context.getATM().setThresholdAmount(
            context.getATM().getThresholdAmount() - withdrawalAmount
        );
        System.out.println("Update ATM's threshold successfully.");
        context.getATM().setState(new EjectCardState());
    }
}
