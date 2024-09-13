package com.greedie.pay.bankingservice.adapter.out.external;

import com.greedie.pay.bankingservice.application.port.out.FirmbankingServicePort;
import com.greedie.pay.common.ExternalSystemAdapter;
import org.springframework.stereotype.Service;

@Service
@ExternalSystemAdapter
public class FirmbankingServiceAdaptor implements FirmbankingServicePort {
    @Override
    public FirmbankingServiceResponse send(FirmbankingServiceRequest request) {
        return new FirmbankingServiceResponse(0);
    }
}
