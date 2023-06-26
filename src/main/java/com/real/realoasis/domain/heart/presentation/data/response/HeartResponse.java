package com.real.realoasis.domain.heart.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class HeartResponse {
    private final int level;
    private final long levelBar;
    private final int max;
}
