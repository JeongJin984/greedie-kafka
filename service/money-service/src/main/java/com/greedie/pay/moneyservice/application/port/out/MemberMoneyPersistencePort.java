package com.greedie.pay.moneyservice.application.port.out;

import com.greedie.pay.moneyservice.adapter.out.persistence.MemberMoneyJpaEntity;

import java.math.BigDecimal;

public interface MemberMoneyPersistencePort {
    MemberMoneyJpaEntity createMemberMoney(String membershipId, String currency, BigDecimal amount) throws IllegalArgumentException;
    MemberMoneyJpaEntity chargeMemberMoney(String membershipId, String currency, BigDecimal amount);
    MemberMoneyJpaEntity consumeMemberMoney(String membershipId, String currency, BigDecimal amount);
    MemberMoneyJpaEntity findMyMemberMoney(String membershipId, String currency);
}
