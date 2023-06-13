package com.real.realoasis.domain.heart.presentation;

import com.real.realoasis.domain.heart.data.response.HeartResponse;
import com.real.realoasis.domain.heart.service.HeartService;
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
    private final HeartService heartService;

    @GetMapping
    public ResponseEntity<HeartResponse> getHeart(){
        HeartResponse heartResponse = heartService.getHeart();
        return new ResponseEntity<>(heartResponse, HttpStatus.OK);
    }
}
