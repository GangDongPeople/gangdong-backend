package com.zerowaste.gangdongbackend.common.errorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER NOT FOUNDED"),               // 미가입 회원
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "PASSWORD IS INVALID"),    // 비밀번호 불일치
    DUPLICATE_ID(HttpStatus.CONFLICT, "DUPLICATE ID"),                  // 아이디 중복
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "DUPLICATE EMAIL"),            // 이메일 중복
    DUPLICATE_MOBILE_PHONE(HttpStatus.CONFLICT, "DUPLICATE MOBILE PHONE");  // 핸드폰 번호 중복

    private HttpStatus httpStatus;
    private String message;

    MemberErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
