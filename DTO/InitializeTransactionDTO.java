package DTO;

public class InitializeTransactionDTO {
    private int atmId;

    public InitializeTransactionDTO(int atmId) {
        this.atmId = atmId;
    }

    public int getATMId() {
        return atmId;
    }
}
