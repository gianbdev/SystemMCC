package com.mygdv.mc_credit_disbursement_service.service;

import com.mygdv.mc_credit_disbursement_service.client.AccountRESTClient;
import com.mygdv.mc_credit_disbursement_service.dto.AccountDTO;
import com.mygdv.mc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.mygdv.mc_credit_disbursement_service.dto.DepositDTO;
import com.mygdv.mc_credit_disbursement_service.entity.CreditDisbursementEntity;
import com.mygdv.mc_credit_disbursement_service.repository.CreditDisbursementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CreditDisbursementServiceImpl implements CreditDisbursementService {

    private final CreditDisbursementRepository creditDisbursementRepository;
    private final AccountRESTClient accountRESTClient;

    public CreditDisbursementServiceImpl(CreditDisbursementRepository creditDisbursementRepository, AccountRESTClient accountRESTClient) {
        this.creditDisbursementRepository = creditDisbursementRepository;
        this.accountRESTClient = accountRESTClient;
    }

    @Override
    public List<CreditDisbursementDTO> getAll() {
        return this.creditDisbursementRepository.findAll().stream().map(CreditDisbursementEntity::getDTO).toList();
    }

    @Override
    public CreditDisbursementDTO add(CreditDisbursementDTO creditDisbursementDTO) {
        log.info("Add credit disbursement {}", creditDisbursementDTO);
        ResponseEntity<AccountDTO> responseEntityDepositInAccount = this.accountRESTClient.depositInAccount(
                DepositDTO.builder().
                        accountNumber(creditDisbursementDTO.getAccountNumber()).
                        ammount(creditDisbursementDTO.getAmount()).
                        customerCu(creditDisbursementDTO.getCustomerCu()).
                        build()
        );
        if (responseEntityDepositInAccount.getStatusCode().is2xxSuccessful()) {
            log.info("Deposit in account successful");
            CreditDisbursementEntity creditDisbursementEntity = new CreditDisbursementEntity();
            creditDisbursementEntity.setData(creditDisbursementDTO);
            return this.creditDisbursementRepository.save(creditDisbursementEntity).getDTO();
        }
        return CreditDisbursementDTO.builder().build();
    }

    @Override
    public CreditDisbursementDTO update(CreditDisbursementDTO creditDisbursementDTO) {
        return null;
    }

    @Override
    public CreditDisbursementDTO delete(CreditDisbursementDTO creditDisbursementDTO) {
        return null;
    }

    @Override
    public CreditDisbursementDTO getById(String id) {
        return null;
    }
}
