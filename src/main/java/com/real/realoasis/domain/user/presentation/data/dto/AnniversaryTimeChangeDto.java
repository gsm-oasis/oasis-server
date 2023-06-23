package com.real.realoasis.domain.user.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class AnniversaryTimeChangeDto {
    private final long anniversaryTime;
}
