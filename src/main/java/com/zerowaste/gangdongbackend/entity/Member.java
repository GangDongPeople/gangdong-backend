package com.zerowaste.gangdongbackend.entity;

import com.zerowaste.gangdongbackend.common.constants.Role;
import com.zerowaste.gangdongbackend.member.dto.MemberJoinReqDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Member extends BaseTime{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private String webId;

    @Column(nullable = false)
    private String webPw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private String mobilePhone;

    @Column(nullable = false)
    private String genderDiv;

    @Column(nullable = false)
    private String zipNo;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String detailAddress;

}
