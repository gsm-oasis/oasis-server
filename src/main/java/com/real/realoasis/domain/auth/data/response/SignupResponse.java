package com.real.realoasis.domain.auth.data.response;

import lombok.*;


@Builder
@Getter
@RequiredArgsConstructor
public class SignupResponse {
    private final String code;
}
