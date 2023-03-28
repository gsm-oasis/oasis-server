package com.real.realoasis.domain.auth.presentation.data.response;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class SearchPwResponse {
    private final String password;
}
