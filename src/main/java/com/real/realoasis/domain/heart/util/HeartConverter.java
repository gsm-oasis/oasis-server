package com.real.realoasis.domain.heart.util;

import com.real.realoasis.domain.heart.data.dto.HeartDto;
import com.real.realoasis.domain.heart.data.response.HeartResponse;


public interface HeartConverter {
    HeartDto toDto(int level);

    HeartResponse toResponse(HeartDto heartDto);
}
