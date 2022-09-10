package com.zerowaste.gangdongbackend.member.dto;

import com.zerowaste.gangdongbackend.common.constants.Role;
import com.zerowaste.gangdongbackend.jwt.JwtTokenResDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class MemberLoginResDto {

    private Long id;
    private Role role;
    private String webId;
    private JwtTokenResDto token;
}
