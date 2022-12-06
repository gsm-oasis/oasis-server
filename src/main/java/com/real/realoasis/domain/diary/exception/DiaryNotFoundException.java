package com.real.realoasis.domain.diary.exception;


import com.real.realoasis.global.error.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DiaryNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;
}
