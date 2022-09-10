package com.zerowaste.gangdongbackend.member;

import com.zerowaste.gangdongbackend.common.constants.Role;
import com.zerowaste.gangdongbackend.common.errorCode.MemberErrorCode;
import com.zerowaste.gangdongbackend.entity.Member;
import com.zerowaste.gangdongbackend.exception.MemberException;
import com.zerowaste.gangdongbackend.jwt.JwtProvider;
import com.zerowaste.gangdongbackend.jwt.JwtTokenResDto;
import com.zerowaste.gangdongbackend.member.dto.MemberJoinReqDto;
import com.zerowaste.gangdongbackend.member.dto.MemberLoginReqDto;
import com.zerowaste.gangdongbackend.member.dto.MemberLoginResDto;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    // TODO: 중복검사 추가해야함
    // 회원가입
    public void signUp(MemberJoinReqDto reqDto) throws MemberException {

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

        duplicateCheckByWebId(member.getWebId());
        duplicateCheckByEmail(member.getEmail());
        duplicateCheckByMobilePhone(member.getMobilePhone());

        memberRepository.save(member);
    }

    // 중복체크
    public boolean duplicateCheckByWebId(String webId) throws MemberException {
        Member member = memberRepository.findByWebId(webId);
        if (member != null) {
            throw new MemberException(MemberErrorCode.DUPLICATE_ID);
        }
        return false;
    }

    public boolean duplicateCheckByEmail(String email) throws MemberException {
        Member member = memberRepository.findByEmail(email);
        if (member != null) {
            throw new MemberException(MemberErrorCode.DUPLICATE_EMAIL);
        }
        return false;
    }

    public boolean duplicateCheckByMobilePhone(String mobilePhone) throws MemberException {
        Member member = memberRepository.findByMobilePhone(mobilePhone);
        if (member != null) {
            throw new MemberException(MemberErrorCode.DUPLICATE_MOBILE_PHONE);
        }
        return false;
    }

    // 로그인
    public MemberLoginResDto signIn(MemberLoginReqDto reqDto) throws MemberException {
        // 회원가입 여부 체크
        Member member = memberRepository.findByWebId(reqDto.getWebId());

        if (member == null) {
            throw new MemberException(MemberErrorCode.USER_NOT_FOUND);
        } else if (!reqDto.getWebPw().equals(member.getWebPw())) {
            throw new MemberException(MemberErrorCode.INVALID_PASSWORD);
        }

        String token = jwtProvider.createToken(member.getName());
        Claims claims = jwtProvider.parseJwtToken("Bearer " + token);

        return MemberLoginResDto.builder()
                .id(member.getId())
                .role(member.getRole())
                .webId(member.getWebId())
                .token(new JwtTokenResDto(token, claims.getSubject(), claims.getIssuedAt(), claims.getExpiration()))
                .build();
    }
}
