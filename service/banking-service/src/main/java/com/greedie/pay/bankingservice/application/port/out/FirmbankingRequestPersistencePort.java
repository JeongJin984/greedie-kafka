package com.greedie.pay.bankingservice.application.port.out;


import com.greedie.pay.bankingservice.adapter.out.persistence.entity.FirmbankingRequestEntity;
import com.greedie.pay.bankingservice.domain.FirmbankingRequest;

import java.math.BigDecimal;

public interface FirmbankingRequestPersistencePort {
    FirmbankingRequestEntity createFirmbankingRequest(
            String fromBankName,
            String fromBankAccountNumber,
            String toBankName,
            String toBankAccountNumber,
            BigDecimal moneyAmount,
            FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus
    );
}
