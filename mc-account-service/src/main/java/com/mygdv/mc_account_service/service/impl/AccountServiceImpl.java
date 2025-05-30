package com.mygdv.mc_account_service.service.impl;

import com.mygdv.mc_account_service.client.CustomerRESTClient;
import com.mygdv.mc_account_service.dto.AccountDTO;
import com.mygdv.mc_account_service.dto.CustomerDTO;
import com.mygdv.mc_account_service.dto.DepositDTO;
import com.mygdv.mc_account_service.entity.AccountEntity;
import com.mygdv.mc_account_service.repository.AccountRepository;
import com.mygdv.mc_account_service.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRESTClient customerRESTClient;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRESTClient customerRESTClient) {
        this.accountRepository = accountRepository;
        this.customerRESTClient = customerRESTClient;
    }

    @Override
    public List<AccountDTO> getAll() {
        return this.accountRepository.findAll().stream().map(AccountEntity::getDTO).toList();
    }

    @Override
    public AccountDTO add(AccountDTO accountDTO) {
        ResponseEntity<CustomerDTO> responseEntityNewCustomerDTO = this.customerRESTClient.add(accountDTO.getCustomer());
        if (responseEntityNewCustomerDTO.getStatusCode().is2xxSuccessful()) {
            log.info("Customer added successfully");
            accountDTO.setCustomer(responseEntityNewCustomerDTO.getBody());
            log.info("Add account to account repository, {}", accountDTO);
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setData(accountDTO);
            return this.accountRepository.save(accountEntity).getDTO();
        } else {
            log.error("Customer add failer");
            return AccountDTO.builder().build();
        }
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO delete(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO getById(String id) {
        return null;
    }

    @Override
    public AccountDTO depositInAccount(DepositDTO depositDTO) {
        log.info("Deposit into account repository, {}", depositDTO);
        Optional<AccountEntity> optionalAccountEntity = this.accountRepository.
                findByAccountNumberAndCustomerCu(depositDTO.getAccountNumber(), depositDTO.getCustomerCu());
        if (optionalAccountEntity.isPresent()) {
            AccountEntity accountEntity = optionalAccountEntity.get();
            accountEntity.setAccountBalance(accountEntity.getAccountBalance().add(depositDTO.getAmmount()));
            return this.accountRepository.save(accountEntity).getDTO();
        }
        return AccountDTO.builder().build();
    }

}