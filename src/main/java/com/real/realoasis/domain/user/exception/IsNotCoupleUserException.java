package com.real.realoasis.domain.user.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IsNotCoupleUserException extends RuntimeException {
    private final ErrorCode errorCode;
}
