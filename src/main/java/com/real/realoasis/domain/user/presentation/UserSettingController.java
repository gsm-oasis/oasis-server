package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.dto.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.presentation.dto.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.presentation.dto.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.presentation.dto.request.QuestionTimeChangeRequest;
import com.real.realoasis.domain.user.presentation.dto.response.SettingResponse;
import com.real.realoasis.domain.user.service.*;
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
    private final PasswordChangeService passwordChangeService;
    private final QuestionTimeChangeService questionTimeChangeService;
    private final AnniversaryTimeChangeService anniversaryTimeChangeService;

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

    // 비밀번호 변경 페이지
    @PutMapping("/change/password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest){
        passwordChangeService.passwordChange(passwordChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 질문시간 변경 페이지
    @PutMapping("/change/questiontime")
    public ResponseEntity<Void> changeQuestionTime(@RequestBody QuestionTimeChangeRequest questionTimeChangeRequest){
        questionTimeChangeService.questionTimeChange(questionTimeChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 기념일 알림 시간 변경 페이지
    @PutMapping("/change/anniversarytime")
    public ResponseEntity<Void> changeAnniversaryTIme(@RequestBody AnniversaryTimeChangeRequest anniversaryTimeChangeRequest){
        anniversaryTimeChangeService.anniversaryTimeChange(anniversaryTimeChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
