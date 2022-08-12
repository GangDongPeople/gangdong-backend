package com.zerowaste.gangdongbackend.member.dto;

import com.zerowaste.gangdongbackend.common.constants.Role;
import lombok.Getter;

@Getter
public class MemberJoinReqDto {

    private Role role;
    private String webId;
    private String webPw;
    private String name;
    private String email;
    private String birthday;
    private String mobilePhone;
    private String genderDiv;
    private String zipNo;
    private String address;
    private String detailAddress;
}
