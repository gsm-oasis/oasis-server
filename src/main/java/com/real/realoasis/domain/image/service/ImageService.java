package com.real.realoasis.domain.image.service;

import com.real.realoasis.domain.image.data.ImageUploadDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageUploadDto upload(List<MultipartFile> multipartFileList) throws Exception;
}
