package com.greedie.pay.membership.application.port.out;

import com.greedie.pay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.greedie.pay.membership.domain.Membership;

public interface SignUpPersistencePort {
    MembershipJpaEntity registerMember(Membership membership);
}
