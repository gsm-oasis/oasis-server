package com.real.realoasis.domain.anniversary.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AnniversaryListResponse {
    private final long idx;
    private final String date;
    private final String name;
}
