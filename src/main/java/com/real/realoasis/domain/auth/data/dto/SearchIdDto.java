package com.real.realoasis.domain.auth.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class SearchIdDto {
    private final String email;
}
