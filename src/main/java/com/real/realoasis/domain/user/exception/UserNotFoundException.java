package com.real.realoasis.domain.user.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UserNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
}
