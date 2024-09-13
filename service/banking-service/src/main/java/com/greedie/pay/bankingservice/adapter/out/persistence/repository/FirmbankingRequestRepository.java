package com.greedie.pay.bankingservice.adapter.out.persistence.repository;

import com.greedie.pay.bankingservice.adapter.out.persistence.entity.FirmbankingRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmbankingRequestRepository extends JpaRepository<FirmbankingRequestEntity, Long> {
}
