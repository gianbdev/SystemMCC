package com.mygdv.mc_credit_disbursement_service.client;

import com.mygdv.mc_credit_disbursement_service.dto.AccountDTO;
import com.mygdv.mc_credit_disbursement_service.dto.DepositDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${feign.clients.account.name}", url = "${feign.clients.account.url}")
public interface AccountRESTClient {

    @PutMapping
    ResponseEntity<AccountDTO> depositInAccount(@RequestBody DepositDTO depositDTO);

}