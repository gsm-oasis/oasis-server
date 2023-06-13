package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.data.dto.AnniversaryTimeChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.presentation.data.dto.NicknameChangeDto;
import com.real.realoasis.domain.user.presentation.data.dto.PasswordChangeDto;
import com.real.realoasis.domain.user.presentation.data.request.AnniversaryTimeChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.presentation.data.request.NicknameChangeRequest;
import com.real.realoasis.domain.user.presentation.data.request.PasswordChangeRequest;
import com.real.realoasis.domain.user.presentation.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.presentation.data.response.SettingResponse;
import com.real.realoasis.domain.user.service.*;
import com.real.realoasis.domain.user.service.Impl.UpdateAnniversaryTimeServiceImpl;
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
    private final UpdateAnniversaryTimeService updateAnniversaryTimeService;
    private final WithdrawalService withdrawalService;
    private final UserConverter userConverter;
    private final UserSettingConverter userSettingConverter;

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
        ConnectCoupleResponse connectCoupleResponse = connectCoupleService.connectCouple(connectCoupleDto);
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

    // 기념일 알림 시간 변경 페이지
    @PatchMapping("/anniversarytime")
    public ResponseEntity<Void> changeAnniversaryTime(@RequestBody AnniversaryTimeChangeRequest anniversaryTimeChangeRequest){
        AnniversaryTimeChangeDto anniversaryTimeChangeDto = userSettingConverter.toAnniversaryTimeChangeDto(anniversaryTimeChangeRequest);
        updateAnniversaryTimeService.update(anniversaryTimeChangeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
