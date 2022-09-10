package com.zerowaste.gangdongbackend.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class JwtTokenResDto {

    private String token;
    private String subject;
    private Date issuedTime;
    private Date expiredTime;


}
