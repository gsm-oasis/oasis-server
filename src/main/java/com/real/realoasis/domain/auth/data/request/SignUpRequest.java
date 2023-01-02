package com.real.realoasis.domain.auth.data.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String id;
    private String email;
    private String password;
    private String nickname;
}
