package com.zerowaste.gangdongbackend.exception;

import com.zerowaste.gangdongbackend.common.errorCode.MemberErrorCode;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException{

    private MemberErrorCode errorCode;

    public MemberException(MemberErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public MemberException(String message, MemberErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
