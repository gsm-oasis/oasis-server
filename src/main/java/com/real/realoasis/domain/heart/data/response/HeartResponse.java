package com.real.realoasis.domain.heart.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class HeartResponse {
    private final int level;
}
