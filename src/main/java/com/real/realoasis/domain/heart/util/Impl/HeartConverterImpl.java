package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;
import com.real.realoasis.domain.heart.util.HeartConverter;
import org.springframework.stereotype.Component;

@Component
public class HeartConverterImpl implements HeartConverter {
    @Override
    public HeartDto toDto(Couple couple, int max) {
        return HeartDto.builder()
                .level(couple.getHeart().getLevel())
                .levelBar(couple.getHeart().getLevelBar())
                .max(max)
                .build();
    }

    @Override
    public HeartResponse toResponse(HeartDto heartDto) {
        return HeartResponse.builder()
                .level(heartDto.getLevel())
                .levelBar(heartDto.getLevelBar())
                .max(heartDto.getMax())
                .build();
    }
}
