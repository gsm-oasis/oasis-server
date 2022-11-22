package com.real.realoasis.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //user
    USER_NOT_FOUND_EXCEPTION("아이디를 찾을 수 없습니다.",404);

    private final String message;
    private final int status;
}
