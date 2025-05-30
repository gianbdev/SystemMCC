package com.mygdv.mc_account_service.entity;

import com.mygdv.mc_account_service.dto.AccountDTO;
import com.mygdv.mc_account_service.dto.CustomerDTO;
import com.mygdv.mc_account_service.util.IMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountEntity implements IMapper<AccountDTO>, Serializable {

    @Serial
    private static final long serialVersionUID = 9;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, length = 60)
    private String id;
    @Column(name = "account_number", nullable = false, length = 13)
    private String accountNumber;
    @Column(name = "account_name", nullable = false, length = 60)
    private String accountName;
    @Column(name = "account_balance", precision = 10, scale = 2)
    private BigDecimal accountBalance;
    @Column(name = "account_cu", nullable = false, length = 20)
    private  String customerCu;

    @Override
    public AccountDTO getDTO() {
        return AccountDTO.builder()
                .id(this.id)
                .accountNumber(this.accountNumber)
                .accountName(this.accountName)
                .accountBalance(this.accountBalance)
                .customer(CustomerDTO.builder()
                        .cu(this.customerCu)
                        .build())
                .build();
    }

    @Override
    public void setData(AccountDTO accountDTO) {
        this.id = accountDTO.getId();
        this.accountNumber = accountDTO.getAccountNumber();
        this.accountName = accountDTO.getAccountName();
        this.accountBalance = accountDTO.getAccountBalance();
        this.customerCu = accountDTO.getCustomer().getCu();
    }

}