package com.mygdv.mc_account_service.service;

import com.mygdv.mc_account_service.dto.AccountDTO;
import com.mygdv.mc_account_service.dto.DepositDTO;
import com.mygdv.mc_account_service.util.ICrud;

public interface AccountService extends ICrud<AccountDTO> {

    public AccountDTO depositInAccount(DepositDTO depositDTO);

}