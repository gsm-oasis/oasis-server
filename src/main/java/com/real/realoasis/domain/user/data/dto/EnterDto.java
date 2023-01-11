package com.real.realoasis.domain.user.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class EnterDto {
    private final String firstDay;
}
