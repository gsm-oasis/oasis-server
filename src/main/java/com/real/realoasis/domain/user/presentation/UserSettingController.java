package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.dto.response.SettingResponse;
import com.real.realoasis.domain.user.service.GetSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/setting")
public class UserSettingController {
    private final GetSettingService getSettingService;

    @GetMapping("/")
    public ResponseEntity<SettingResponse> getSetting(){
        return new ResponseEntity<>(getSettingService.getSetting(), HttpStatus.OK);
    }
}
