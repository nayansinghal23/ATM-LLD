package state;

import java.util.Date;

import emums.ATMState;
import models.Card;

public class CardAndPinReadingState implements State {
    @Override
    public ATMState getATMState() {
        return ATMState.CARD_AND_PIN_READING;
    }

    @Override
    public void execute(TransactionContext context, InputProvider inputProvider) {
        System.out.println("Reading card and verifying your entered PIN ...");
        Card card = context.getCard();

        if(card.getExpiryDate().before(new Date())) {
            throw new IllegalStateException("Card is already expired.");
        }

        context.setEnteredPIN(inputProvider.readPin());

        if(card.getPin() != context.getEnteredPIN()) {
            throw new IllegalStateException("Entered PIN doesn't match. Please try again later.");
        }
        context.getATM().setState(new EnterWithdrawalAmountState());
    }
}
