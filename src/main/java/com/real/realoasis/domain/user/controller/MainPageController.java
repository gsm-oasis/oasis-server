package com.real.realoasis.domain.user.controller;

import com.real.realoasis.domain.user.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.data.response.MainPageResponse;
import com.real.realoasis.domain.user.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mainpage")
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageService mainPageService;

    @GetMapping("/")
    public ResponseEntity<MainPageResponse> getMainPage(){
        MainPageResponse mainPageResponse = mainPageService.getMainPage();
        return new ResponseEntity<>( mainPageResponse, HttpStatus.OK);
    }

    @PostMapping("/enter/datingdate")
    public ResponseEntity<Void> datingDateEnter(@RequestBody DatingDateEnterRequest datingDateEnterRequest){
        mainPageService.datingDateEnter(datingDateEnterRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
