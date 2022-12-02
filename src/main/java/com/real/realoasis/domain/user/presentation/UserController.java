package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.user.service.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final WithdrawalService withdrawalService;

    @DeleteMapping("/withdrawal")
    public ResponseEntity<Void> withdrawal(){
        withdrawalService.withdrawal();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
