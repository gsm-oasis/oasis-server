package com.real.realoasis.domain.user.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PasswordNotMatchException extends RuntimeException {
    private final ErrorCode errorCode;
}
