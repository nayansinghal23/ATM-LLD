package DTO;

import models.Card;

public class DispenseCashDTO {
    private final int atmId;
    private final int transactionId;
    private final int amount;
    private final Card card;

    // Builder Design Pattern
    public DispenseCashDTO(int atmId, int transactionId, int amount, Card card) {
        this.atmId = atmId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.card = card;
    }

    public int getATMId() {
        return atmId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public Card getCard() {
        return card;
    }
}
