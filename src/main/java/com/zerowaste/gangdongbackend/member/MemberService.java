package com.zerowaste.gangdongbackend.member;

import com.zerowaste.gangdongbackend.common.constants.Role;
import com.zerowaste.gangdongbackend.entity.Member;
import com.zerowaste.gangdongbackend.member.dto.MemberJoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public void signUp(MemberJoinReqDto reqDto) {
        Member member = Member.builder()
                .role(Role.USER)
                .webId(reqDto.getWebId())
                .webPw(reqDto.getWebPw())
                .name(reqDto.getName())
                .email(reqDto.getEmail())
                .birthday(reqDto.getBirthday())
                .mobilePhone(reqDto.getMobilePhone())
                .genderDiv(reqDto.getGenderDiv())
                .zipNo(reqDto.getZipNo())
                .address(reqDto.getAddress())
                .detailAddress(reqDto.getDetailAddress())
                .build();

        memberRepository.save(member);
    }

    // 중복체크
    public boolean duplicateCheckByWebId(String webId) {
        Member findByWebId = memberRepository.findByWebId(webId);
        return findByWebId == null;
    }

    public boolean duplicateCheckByEmail(String email) {
        Member findByEmail = memberRepository.findByEmail(email);
        return findByEmail == null;
    }

    public boolean duplicateCheckByMobilePhone(String mobilePhone) {
        Member findByMobilePhone = memberRepository.findByMobilePhone(mobilePhone);
        return findByMobilePhone == null;
    }
}
