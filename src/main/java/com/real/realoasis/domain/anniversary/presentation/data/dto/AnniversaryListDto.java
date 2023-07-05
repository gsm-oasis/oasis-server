package com.real.realoasis.domain.anniversary.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AnniversaryListDto {
    private final long idx;
    private final String date;
}
