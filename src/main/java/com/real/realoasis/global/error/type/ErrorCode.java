package com.real.realoasis.global.error.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_NOT_MATCH_EXCEPTION("비밀번호가 일치하지 않습니다.", 400),
    INVALID_AUTH_CODE("올바르지 않는 인증코드 입니다.", 400),
    UNAUTHORIZED("UNAUTHORIZED", 401),
    EXPIRATION_TOKEN_EXCEPTION("만료된 토큰입니다.", 401),
    INVALID_TOKEN_EXCEPTION("유효하지 않은 토큰입니다.", 401),
    USER_NOT_FOUND_EXCEPTION("USER 를 찾을 수 없습니다.",404),
    INVALID_AUTH_CODE_EXCEPTION("옳지 않은 인증 코드입니다.", 404),
    QUESTION_NOT_FOUND_EXCEPTION("질문을 찾을 수 없습니다.",404),

    QUESTION_ANSWER_NOT_FOUND_EXCEPTION("답변을 찾을 수 없습니다.", 404),
    COUPLE_NOT_FOUND("Couple이 존재하지 않습니다.", 404),
    USER_CODE_NOT_FOUND("찾을 수 없는 커플코드입니다.", 404),
    DIARY_NOT_FOUND_EXCEPTION("일기를 찾을 수 없습니다.", 404),
    REFRESH_NOT_FOUND("재발급 토큰을 찾을 수 없습니다.", 404),
    DUPLICATE_ID_EXCEPTION("이미 존재하는 아이디입니다.",409),
    IS_NOT_COUPLE_USER("커플 유저가 아닙니다.", 409),
    DUPLICATE_ANNIVERSARY("이미 등록한 기념일입니다.", 409),
    DUPLICATE_WRITE_DIARY("이미 일기를 작성하였습니다.", 409);



    private final String message;
    private final int status;
}
