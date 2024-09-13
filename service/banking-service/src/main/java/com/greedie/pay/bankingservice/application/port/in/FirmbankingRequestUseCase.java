package com.greedie.pay.bankingservice.application.port.in;

import com.greedie.pay.bankingservice.domain.FirmbankingRequest;

public interface FirmbankingRequestUseCase {
    FirmbankingRequest requestFirmbankingCheckAccount(FirmbankingRequestCommand command);
}
