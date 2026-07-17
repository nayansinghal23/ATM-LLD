package DTO;

import models.Card;

public class ValidateUserBankAmountDTO {
    private final Card card;
    private final int withdrawalAmount;

    public ValidateUserBankAmountDTO(Card card, int withdrawalAmount) {
        this.card = card;
        this.withdrawalAmount = withdrawalAmount;
    }

    public Card getCard() {
        return card;
    }

    public int getWithdrawalAmount() {
        return withdrawalAmount;
    }
}
