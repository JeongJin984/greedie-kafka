package com.greedie.pay.bankingservice.adapter.out.persistence.entity;

import com.greedie.pay.bankingservice.domain.FirmbankingRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "firmbanking_request")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FirmbankingRequestEntity {
    @Id
    private String requestId;

    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private BigDecimal moneyAmount;
    @Setter
    private FirmbankingRequest.FirmbankingRequestStatus firmbankingRequestStatus;

}
