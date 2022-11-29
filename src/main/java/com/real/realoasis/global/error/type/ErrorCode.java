package com.real.realoasis.global.error.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //user
    USER_NOT_FOUND_EXCEPTION("아이디를 찾을 수 없습니다.",404),
    PASSWORD_NOT_MATCH_EXCEPTION("비밀번호가 일치하지 않습니다.", 400),
    DUPLICATE_EMAIL_EXCEPTION("이미 존재하는 이메일입니다.",409),


    // token
    EXPIRATION_TOKEN_EXCEPTION("만료된 토큰입니다.", 403),
    INVALID_TOKEN_EXCEPTION("유효하지 않은 토큰입니다.", 403);

    private final String message;
    private final int status;
}
