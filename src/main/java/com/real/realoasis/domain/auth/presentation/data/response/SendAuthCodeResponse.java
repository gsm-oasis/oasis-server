package com.real.realoasis.domain.auth.presentation.data.response;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class SendAuthCodeResponse {
    private final String sentCode;
}
