package com.zerowaste.gangdongbackend.member;

import com.zerowaste.gangdongbackend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByWebId(String webId);

    Member findByEmail(String email);

    Member findByMobilePhone(String mobilePhone);
}
