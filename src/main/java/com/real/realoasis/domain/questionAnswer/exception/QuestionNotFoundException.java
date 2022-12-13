package com.real.realoasis.domain.questionAnswer.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class QuestionNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
}
