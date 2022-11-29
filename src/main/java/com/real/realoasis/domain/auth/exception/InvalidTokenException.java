package com.real.realoasis.domain.auth.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidTokenException extends RuntimeException{
    private final ErrorCode errorCode;
}
