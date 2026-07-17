package backend;

import DTO.ATMThresholdAmountDTO;
import DTO.ChangeATMStateDTO;
import DTO.DispenseCashDTO;
import DTO.GetATMStateDTO;
import DTO.InitializeTransactionDTO;
import DTO.ValidateUserBankAmountDTO;
import emums.ATMState;

public interface Backend {
    int createTransaction(InitializeTransactionDTO dto);
    boolean changeATMState(ChangeATMStateDTO dto);
    boolean validateUserBankAmount(ValidateUserBankAmountDTO dto);
    boolean dispenseCash(DispenseCashDTO dto);
    int getATMThresholdAmount(ATMThresholdAmountDTO dto);
    ATMState getAtmState(GetATMStateDTO dto);
}
