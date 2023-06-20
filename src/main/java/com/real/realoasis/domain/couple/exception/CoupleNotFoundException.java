package com.real.realoasis.domain.couple.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoupleNotFoundException extends RuntimeException {
    private ErrorCode errorCode;
}
