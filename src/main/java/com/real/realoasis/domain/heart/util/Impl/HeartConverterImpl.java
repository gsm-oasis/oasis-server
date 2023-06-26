package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;
import com.real.realoasis.domain.heart.util.HeartConverter;
import org.springframework.stereotype.Component;

@Component
public class HeartConverterImpl implements HeartConverter {
    @Override
    public HeartDto toDto(Couple couple) {
        return HeartDto.builder()
                .level(couple.getHeart().getLevel())
                .levelBar(couple.getHeart().getLevelBar())
                .build();
    }

    @Override
    public HeartResponse toResponse(HeartDto heartDto) {
        return HeartResponse.builder()
                .level(heartDto.getLevel())
                .levelBar(heartDto.getLevelBar())
                .build();
    }
}
