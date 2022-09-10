package com.zerowaste.gangdongbackend.common;

import com.zerowaste.gangdongbackend.common.errorCode.MemberErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResBody {

    private String result;
    private String data;

    public static ResponseEntity<ErrorResBody> toResponseEntity(MemberErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResBody.builder()
                        .result(errorCode.getHttpStatus().toString())
                        .data(errorCode.getMessage())
                        .build());
    }
}
