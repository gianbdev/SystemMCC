package com.mygdv.mc_account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositDTO {

    private String accountNumber;
    private BigDecimal ammount;
    private String customerCu;

}