package com.greedie.pay.bankingservice.application.port.out;


import com.greedie.pay.bankingservice.adapter.out.external.FirmbankingServiceRequest;
import com.greedie.pay.bankingservice.adapter.out.external.FirmbankingServiceResponse;

public interface FirmbankingServicePort {
    FirmbankingServiceResponse send(FirmbankingServiceRequest request);
}
