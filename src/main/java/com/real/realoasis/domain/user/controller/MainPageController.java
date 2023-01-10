package com.real.realoasis.domain.user.controller;

import com.real.realoasis.domain.user.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.data.response.MainPageResponse;
import com.real.realoasis.domain.user.service.DatingDateEnterService;
import com.real.realoasis.domain.user.service.GetMainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mainpage")
@RequiredArgsConstructor
public class MainPageController {
    private final DatingDateEnterService datingDateEnterService;
    private final GetMainPageService getMainPageService;

    @GetMapping("/")
    public ResponseEntity<MainPageResponse> getMainPage(){
        return new ResponseEntity<>(getMainPageService.getMainPage(), HttpStatus.OK);
    }

    @PostMapping("/enter/datingdate")
    public ResponseEntity<Void> datingDateEnter(@RequestBody DatingDateEnterRequest datingDateEnterRequest){
        datingDateEnterService.datingDateEnter(datingDateEnterRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
