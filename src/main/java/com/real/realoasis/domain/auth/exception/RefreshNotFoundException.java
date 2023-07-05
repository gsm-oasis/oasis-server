package com.real.realoasis.domain.auth.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefreshNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
}
