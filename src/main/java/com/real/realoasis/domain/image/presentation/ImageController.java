package com.real.realoasis.domain.image.presentation;

import com.real.realoasis.domain.image.data.ImageUploadDto;
import com.real.realoasis.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping()
    public ResponseEntity<ImageUploadDto> upload(
            @RequestPart(value = "file", required = false) List<MultipartFile> files) throws Exception {
        return new ResponseEntity<>(imageService.upload(files), HttpStatus.OK);
    }
}
