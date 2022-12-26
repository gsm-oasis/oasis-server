package com.real.realoasis.domain.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<String> upload(List<MultipartFile> multipartFileList) throws Exception;
}
