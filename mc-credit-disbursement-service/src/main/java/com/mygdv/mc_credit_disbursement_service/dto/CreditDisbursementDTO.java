package com.mygdv.mc_credit_disbursement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditDisbursementDTO {

    private String id;
    private BigDecimal amount;
    private Integer termMonths;
    private BigDecimal interestRate;
    private String accountNumber;
    private String customerCu;

}