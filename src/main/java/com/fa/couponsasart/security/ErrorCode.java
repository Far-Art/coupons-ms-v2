package com.fa.couponsasart.security;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    BAD_EMAIL(10_000),
    EMAIL_TAKEN(10_001),
    BAD_PASSWORD(20_000),
    USER_NOT_FOUND(30_000);

    public final int code;

    ErrorCode(int code) {
        this.code = code;
    }
}
