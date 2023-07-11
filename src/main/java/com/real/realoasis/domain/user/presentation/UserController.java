package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.data.dto.*;
import com.real.realoasis.domain.user.presentation.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.presentation.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.presentation.data.response.SettingResponse;
import com.real.realoasis.domain.user.service.*;
import com.real.realoasis.domain.user.util.UserConverter;
import com.real.realoasis.domain.user.util.UserSettingConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final ConnectCoupleService connectCoupleService;
    private final GetSettingService getSettingService;
    private final UpdateNicknameService updateNicknameService;
    private final UpdatePasswordService updatePasswordService;
    private final WithdrawalService withdrawalService;
    private final UserConverter userConverter;
    private final UserSettingConverter userSettingConverter;
    private final UnConnectCoupleService unConnectCoupleService;

    // 회원탈퇴
    @DeleteMapping
    public ResponseEntity<Void> withdrawal(){
        withdrawalService.withdrawal();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 커플연결
    @PostMapping
    public ResponseEntity<ConnectCoupleResponse> connectCouple(@RequestBody ConnectCoupleRequest connectCoupleRequest){
        ConnectCoupleDto connectCoupleDto = userConverter.toDto(connectCoupleRequest);
        ConnectCoupleResDto connectCoupleResDto = connectCoupleService.connectCouple(connectCoupleDto);
        ConnectCoupleResponse connectCoupleResponse = userConverter.toResponse(connectCoupleResDto);
        return new ResponseEntity<>(connectCoupleResponse, HttpStatus.OK);
    }

    // 설정 메인 페이지
    @GetMapping
    public ResponseEntity<SettingResponse> getSetting(){
        SettingResponse settingResponse = getSettingService.getSetting();
        return new ResponseEntity<>(settingResponse, HttpStatus.OK);
    }

    // 닉네임 변경 페이지
    @PatchMapping("/nickname")
    public ResponseEntity<Void> changeNickname(@RequestBody NicknameChangeRequest nicknameChangeRequest){
        NicknameChangeDto nicknameChangeDto = userSettingConverter.toNicknameChangeDto(nicknameChangeRequest);
        updateNicknameService.update(nicknameChangeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 비밀번호 변경 페이지
    @PatchMapping("/password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest){
        PasswordChangeDto passwordChangeDto = userSettingConverter.toPasswordChangeDto(passwordChangeRequest);
        updatePasswordService.update(passwordChangeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 커플 끊기
    @DeleteMapping("/unconnect")
    public ResponseEntity<Void> unConnectCouple() {
        unConnectCoupleService.unConnect();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
