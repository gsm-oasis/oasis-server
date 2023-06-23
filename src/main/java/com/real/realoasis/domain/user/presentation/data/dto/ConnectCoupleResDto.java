package com.real.realoasis.domain.user.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class ConnectCoupleResDto {
    private final String nickname;
}
