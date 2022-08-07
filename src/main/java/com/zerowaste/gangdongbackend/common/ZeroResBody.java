package com.zerowaste.gangdongbackend.common;

import lombok.Getter;

@Getter
public class ZeroResBody {

    private String result;
    private Object data;

    public ZeroResBody(String result) {
        this.result = result;
    }

    public ZeroResBody data(Object data) {
        this.data = data;
        return this;
    }

    public static ZeroResBody success() {
        return new ZeroResBody("success");
    }

    public static ZeroResBody success(Object data) {
        return success().data(data);
    }
}
