package com.real.realoasis.domain.auth.data.request;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class SignUpRequest {
    private final String id;
    private final String email;
    private final String password;
    private final String nickname;
}
