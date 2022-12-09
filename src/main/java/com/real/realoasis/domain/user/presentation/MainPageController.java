package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.dto.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.service.DatingDateEnterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mainpage")
@RequiredArgsConstructor
public class MainPageController {
    private final DatingDateEnterService datingDateEnterService;

    @PostMapping("/enter/datingdate")
    public ResponseEntity<Void> datingDateEnter(@RequestBody DatingDateEnterRequest datingDateEnterRequest){
        datingDateEnterService.datingDateEnter(datingDateEnterRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
