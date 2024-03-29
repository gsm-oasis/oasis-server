package com.real.realoasis.domain.auth.presentation.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendMailRequest {
    private String email;
}
