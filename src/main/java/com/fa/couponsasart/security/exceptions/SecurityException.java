package com.fa.couponsasart.security.exceptions;

import com.fa.couponsasart.security.ErrorCode;
import jakarta.annotation.Nonnull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Access restricted")
public class SecurityException extends RuntimeException {

    private final int errorCode;

    public SecurityException(int errorCode) {
        this.errorCode = errorCode;
    }

    public SecurityException(@Nonnull ErrorCode errorCode) {
        this(errorCode.code);
    }

    public SecurityException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SecurityException(@Nonnull ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode.code;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
