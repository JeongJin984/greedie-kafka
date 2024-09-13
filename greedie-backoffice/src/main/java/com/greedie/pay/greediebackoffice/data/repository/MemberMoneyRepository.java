package com.greedie.pay.greediebackoffice.data.repository;

import com.greedie.pay.greediebackoffice.data.entity.MemberMoneyJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {
}
