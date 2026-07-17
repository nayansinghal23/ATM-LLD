package DTO;

import models.Card;

public class ValidateUserBankAmountDTO {
    private final Card card;

    public ValidateUserBankAmountDTO(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}
