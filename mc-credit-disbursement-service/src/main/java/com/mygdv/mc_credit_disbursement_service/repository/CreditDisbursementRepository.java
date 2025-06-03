package com.mygdv.mc_credit_disbursement_service.repository;

import com.mygdv.mc_credit_disbursement_service.entity.CreditDisbursementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDisbursementRepository extends JpaRepository<CreditDisbursementEntity, String> {
}
