package com.real.realoasis.domain.user.controller;

import com.real.realoasis.domain.user.data.dto.ConnectCoupleDto;
import com.real.realoasis.domain.user.data.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.data.response.ConnectCoupleResponse;
import com.real.realoasis.domain.user.service.UserService;
import com.real.realoasis.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;

    // 회원탈퇴
    @DeleteMapping("/withdrawal")
    public ResponseEntity<Void> withdrawal(){
        userService.withdrawal();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 커플연결
    @PostMapping("/connect/couple")
    public ResponseEntity<ConnectCoupleResponse> connectCouple(@RequestBody ConnectCoupleRequest connectCoupleRequest){
        ConnectCoupleDto connectCoupleDto = userConverter.toDto(connectCoupleRequest);
        ConnectCoupleResponse connectCoupleResponse = userService.connectCouple(connectCoupleDto);
        return new ResponseEntity<>(connectCoupleResponse, HttpStatus.OK);
    }


}
