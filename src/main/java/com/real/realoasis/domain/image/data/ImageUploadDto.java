package com.real.realoasis.domain.image.data;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Builder
public class ImageUploadDto {
    private final List<String> imageUrlList;
}
