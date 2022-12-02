package com.real.realoasis.domain.user.presentation;

import com.real.realoasis.domain.auth.service.EmailService;
import com.real.realoasis.domain.user.presentation.dto.request.SearchIDRequest;
import com.real.realoasis.domain.user.presentation.dto.response.SearchIDResponse;
import com.real.realoasis.domain.user.service.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final WithdrawalService withdrawalService;
    private final EmailService emailService;

    // 회원탈퇴
    @DeleteMapping("/withdrawal")
    public ResponseEntity<Void> withdrawal(){
        withdrawalService.withdrawal();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 이메일을 통해 아이디 찾기
    @PostMapping("/search/id")
    public ResponseEntity<SearchIDResponse> searchID(@RequestBody SearchIDRequest searchIDRequest) throws MessagingException, UnsupportedEncodingException {
        emailService.sendId(searchIDRequest.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
