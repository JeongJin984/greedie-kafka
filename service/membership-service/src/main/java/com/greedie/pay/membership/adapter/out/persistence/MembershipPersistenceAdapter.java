package com.greedie.pay.membership.adapter.out.persistence;

import com.greedie.pay.common.PersistenceAdapter;
import com.greedie.pay.membership.application.port.out.SignUpPersistencePort;
import com.greedie.pay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@PersistenceAdapter
@Service
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements SignUpPersistencePort {
    private final MembershipJpaEntityRepository membershipJpaEntityRepository;

    @Override
    public MembershipJpaEntity registerMember(Membership membership) {
        return membershipJpaEntityRepository.save(new MembershipJpaEntity(
                membership.getMembershipId(),
                membership.getName(),
                membership.getPassword(),
                membership.getEmail(),
                membership.isValid(),
                membership.isCorp()
        ));
    }
}
