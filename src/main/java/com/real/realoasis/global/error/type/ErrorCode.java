package com.real.realoasis.global.error.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //user
    USER_NOT_FOUND_EXCEPTION("아이디를 찾을 수 없습니다.",404),


    // Token
    EXPIRATION_TOKEN("만료된 토큰입니다.", 403),
    INVALID_TOKEN("유효하지 않은 토큰입니다.", 403);

    private final String message;
    private final int status;
}
