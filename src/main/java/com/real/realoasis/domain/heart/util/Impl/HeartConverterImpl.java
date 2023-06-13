package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;
import com.real.realoasis.domain.heart.util.HeartConverter;
import org.springframework.stereotype.Component;

@Component
public class HeartConverterImpl implements HeartConverter {
    @Override
    public HeartDto toDto(int level) {
        return HeartDto.builder()
                .level(level)
                .build();
    }

    @Override
    public HeartResponse toResponse(HeartDto heartDto) {
        return HeartResponse.builder()
                .level(heartDto.getLevel())
                .build();
    }
}
