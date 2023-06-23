package com.real.realoasis.domain.user.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class EnterDto {
    private final String startDay;
}
