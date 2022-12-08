package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.dto.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.presentation.dto.response.SettingResponse;
import com.real.realoasis.domain.user.service.GetSettingService;
import com.real.realoasis.domain.user.service.NicknameChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/setting")
public class UserSettingController {
    private final GetSettingService getSettingService;
    private final NicknameChangeService nicknameChangeService;

    // 설정 메인 페이지
    @GetMapping("/")
    public ResponseEntity<SettingResponse> getSetting(){
        return new ResponseEntity<>(getSettingService.getSetting(), HttpStatus.OK);
    }

    // 닉네임 변경 페이지
    @PutMapping("/change/nickname")
    public ResponseEntity<Void> changeNickname(@RequestBody NicknameChangeRequest nicknameChangeRequest){
        nicknameChangeService.nicknameChange(nicknameChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}