package com.real.realoasis.domain.heart.presentation;

import com.real.realoasis.domain.heart.presentation.data.dto.HeartDto;
import com.real.realoasis.domain.heart.presentation.data.response.HeartResponse;
import com.real.realoasis.domain.heart.service.GetHeartService;
import com.real.realoasis.domain.heart.util.HeartConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heart")
public class HeartController {
    private final GetHeartService heartService;
    private final HeartConverter heartConverter;

    @GetMapping
    public ResponseEntity<HeartResponse> getHeart(){
        HeartDto heartDto = heartService.getHeart();
        HeartResponse heartResponse = heartConverter.toResponse(heartDto);
        return new ResponseEntity<>(heartResponse, HttpStatus.OK);
    }
}
