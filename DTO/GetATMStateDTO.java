package DTO;

public class GetATMStateDTO {
    private final int atmId;

    public GetATMStateDTO(int atmId) {
        this.atmId = atmId;
    }

    public int getAtmId() {
        return atmId;
    }
}
