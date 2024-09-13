package com.greedie.pay.greediebackoffice.data.repository;

import com.greedie.pay.greediebackoffice.data.entity.MembershipJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
