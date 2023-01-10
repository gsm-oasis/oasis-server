package com.real.realoasis.domain.heart.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class HeartDto {
    private final int level;
}
