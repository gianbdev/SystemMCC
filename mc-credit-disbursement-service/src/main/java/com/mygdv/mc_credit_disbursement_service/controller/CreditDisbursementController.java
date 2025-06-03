package com.mygdv.mc_credit_disbursement_service.controller;

import com.mygdv.mc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.mygdv.mc_credit_disbursement_service.service.CreditDisbursementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-disbursements")
public class CreditDisbursementController {

    private final CreditDisbursementService creditDisbursementService;

    public CreditDisbursementController(CreditDisbursementService creditDisbursementService) {
        this.creditDisbursementService = creditDisbursementService;
    }

    @GetMapping
    public List<CreditDisbursementDTO> getAllCreditDisbursement() {
        return this.creditDisbursementService.getAll();
    }

    @PostMapping
    public CreditDisbursementDTO addCreditDisbursement(@RequestBody CreditDisbursementDTO dto) {
        return this.creditDisbursementService.add(dto);
    }

}