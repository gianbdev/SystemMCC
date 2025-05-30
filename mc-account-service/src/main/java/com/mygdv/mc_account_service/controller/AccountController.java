package com.mygdv.mc_account_service.controller;

import com.mygdv.mc_account_service.dto.AccountDTO;
import com.mygdv.mc_account_service.dto.DepositDTO;
import com.mygdv.mc_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDTO> getAllAccount() {
        return this.accountService.getAll();
    }

    @PostMapping
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        return this.accountService.add(accountDTO);
    }

    @PutMapping
    public AccountDTO depositAccount(@RequestBody DepositDTO depositDTO) {
        return this.accountService.depositInAccount(depositDTO);
    }

}