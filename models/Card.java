package models;

import java.util.Date;

public class Card {
    private String cardHolderName;
    private int cardNumber;
    private int pin;
    private Date expiryDate;

    // Builder Design Pattern
    public Card(String cardHolderName, int cardNumber, int pin, Date expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
