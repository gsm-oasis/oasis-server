package com.real.realoasis.domain.anniversary.presentation.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AddAnniversaryRequest {
    private final String anniversaryName;
    private final String anniversaryDate;
}
