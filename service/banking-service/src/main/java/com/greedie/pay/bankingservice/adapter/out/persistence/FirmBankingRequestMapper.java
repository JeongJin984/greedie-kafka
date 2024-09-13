package com.greedie.pay.bankingservice.adapter.out.persistence;

import com.greedie.pay.bankingservice.adapter.out.persistence.entity.FirmbankingRequestEntity;
import com.greedie.pay.bankingservice.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

@Component
public class FirmBankingRequestMapper {
    public FirmbankingRequest mapDomainToEntity(final FirmbankingRequestEntity entity) {
        return FirmbankingRequest.generateFirmbankingRequest(
                entity.getToBankName(),
                entity.getFromBankAccountNumber(),
                entity.getToBankName(),
                entity.getToBankAccountNumber(),
                entity.getMoneyAmount(),
                entity.getFirmbankingRequestStatus()
        );
    }
}
