package com.real.realoasis.domain.heart.util;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;


public interface HeartConverter {
    HeartDto toDto(Couple couple);

    HeartResponse toResponse(HeartDto heartDto);
}
