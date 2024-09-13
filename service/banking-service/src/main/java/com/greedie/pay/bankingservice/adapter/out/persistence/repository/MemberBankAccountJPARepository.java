package com.greedie.pay.bankingservice.adapter.out.persistence.repository;

import com.greedie.pay.bankingservice.adapter.out.persistence.entity.MemberBankAccountJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberBankAccountJPARepository extends JpaRepository<MemberBankAccountJPAEntity, String> {

}
