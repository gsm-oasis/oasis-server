package com.real.realoasis.domain.diary.exception;

import com.real.realoasis.global.error.type.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DuplicateWriteDiaryException extends RuntimeException {
    private final ErrorCode errorCode;
}
