package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.presentation.dto.request.ConnectCoupleRequest;
import com.real.realoasis.domain.user.service.ConnectCoupleService;
import com.real.realoasis.domain.user.service.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final WithdrawalService withdrawalService;
    private final ConnectCoupleService connectCoupleService;

    // 회원탈퇴
    @DeleteMapping("/withdrawal")
    public ResponseEntity<Void> withdrawal(){
        withdrawalService.withdrawal();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 커플연결
    @PostMapping("/connect/couple")
    public ResponseEntity<Void> connectCouple(@RequestBody ConnectCoupleRequest connectCoupleRequest){
        connectCoupleService.connectCouple(connectCoupleRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
