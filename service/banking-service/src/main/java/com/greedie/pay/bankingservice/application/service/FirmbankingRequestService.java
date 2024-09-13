package com.greedie.pay.bankingservice.application.service;

import com.greedie.pay.bankingservice.adapter.out.external.FirmbankingServiceRequest;
import com.greedie.pay.bankingservice.adapter.out.external.FirmbankingServiceResponse;
import com.greedie.pay.bankingservice.adapter.out.persistence.FirmBankingRequestMapper;
import com.greedie.pay.bankingservice.adapter.out.persistence.entity.FirmbankingRequestEntity;
import com.greedie.pay.bankingservice.application.port.in.FirmbankingRequestCommand;
import com.greedie.pay.bankingservice.application.port.in.FirmbankingRequestUseCase;
import com.greedie.pay.bankingservice.application.port.out.FirmbankingRequestPersistencePort;
import com.greedie.pay.bankingservice.application.port.out.FirmbankingServicePort;
import com.greedie.pay.bankingservice.domain.FirmbankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirmbankingRequestService implements FirmbankingRequestUseCase {
    private final FirmBankingRequestMapper mapper;
    private final FirmbankingRequestPersistencePort firmbankingRequestPersistencePort;
    private final FirmbankingServicePort firmbankingServicePort;

    @Override
    public FirmbankingRequest requestFirmbankingCheckAccount(FirmbankingRequestCommand command) {
        FirmbankingRequestEntity firmbankingRequest = firmbankingRequestPersistencePort.createFirmbankingRequest(
                command.getFromBankName(),
                command.getFromAccountNumber(),
                command.getToBankName(),
                command.getToAccountNumber(),
                command.getMoneyAmount(),
                FirmbankingRequest.FirmbankingRequestStatus.REQUEST
        );

        FirmbankingServiceResponse response = firmbankingServicePort.send(new FirmbankingServiceRequest(
                command.getFromBankName(),
                command.getFromAccountNumber(),
                command.getToBankName(),
                command.getToAccountNumber()
        ));

        if(response.status() == 0) {
            firmbankingRequest.setFirmbankingRequestStatus(FirmbankingRequest.FirmbankingRequestStatus.COMPLETED);
        } else {
            firmbankingRequest.setFirmbankingRequestStatus(FirmbankingRequest.FirmbankingRequestStatus.FAIL);
        }
        return mapper.mapDomainToEntity(firmbankingRequest);
    }
}
