package com.real.realoasis.domain.user.controller;

import com.real.realoasis.domain.user.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.data.response.SettingResponse;
import com.real.realoasis.domain.user.service.*;
import com.real.realoasis.domain.user.util.UserSettingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/setting")
public class UserSettingController {
    private final UserSettingService userSettingService;
    private final UserSettingConverter userSettingConverter;

    // 설정 메인 페이지
    @GetMapping
    public ResponseEntity<SettingResponse> getSetting(){
        SettingResponse settingResponse = userSettingService.getSetting();
        return new ResponseEntity<>(settingResponse, HttpStatus.OK);
    }

    // 닉네임 변경 페이지
    @PatchMapping("/change/nickname")
    public ResponseEntity<Void> changeNickname(@RequestBody NicknameChangeRequest nicknameChangeRequest){
        NicknameChangeDto nicknameChangeDto = userSettingConverter.toNicknameChangeDto(nicknameChangeRequest);
        userSettingService.nicknameChange(nicknameChangeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 비밀번호 변경 페이지
    @PatchMapping("/change/password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest){
        PasswordChangeDto passwordChangeDto = userSettingConverter.toPasswordChangeDto(passwordChangeRequest);
        userSettingService.passwordChange(passwordChangeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 기념일 알림 시간 변경 페이지
    @PatchMapping("/change/anniversarytime")
    public ResponseEntity<Void> changeAnniversaryTIme(@RequestBody AnniversaryTimeChangeRequest anniversaryTimeChangeRequest){
        userSettingService.anniversaryTimeChange(anniversaryTimeChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
