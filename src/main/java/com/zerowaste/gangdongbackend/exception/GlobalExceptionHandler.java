package com.zerowaste.gangdongbackend.exception;

import com.zerowaste.gangdongbackend.common.ErrorResBody;
import com.zerowaste.gangdongbackend.common.ZeroResBody;
import com.zerowaste.gangdongbackend.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MemberException.class)
    public ResponseEntity<ErrorResBody> memberException(MemberException e) {
        return ErrorResBody.toResponseEntity(e.getErrorCode());
    }

}
