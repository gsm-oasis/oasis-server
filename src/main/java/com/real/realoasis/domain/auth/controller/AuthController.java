package com.real.realoasis.domain.auth.controller;

import com.real.realoasis.domain.auth.data.request.*;
import com.real.realoasis.domain.auth.data.response.LoginResponse;
import com.real.realoasis.domain.auth.data.response.SearchIDResponse;
import com.real.realoasis.domain.auth.data.response.SearchPWResponse;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;
    private final SignUpService signUpService;
    private final ReissueTokenService reissueTokenService;
    private final EmailService emailService;
    private final SearchPWService searchPWService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signUp(@Valid @RequestBody SignUpRequest signupRequest){
        return new ResponseEntity<>(signUpService.signUp(signupRequest),HttpStatus.CREATED);
    }

    // 이메일에 인증코드 전송
    @PostMapping("/sendmail")
    public ResponseEntity<Void> sendMail(@RequestBody SendMailRequest sendMailRequest) throws MessagingException, UnsupportedEncodingException {
        emailService.sendEmail(sendMailRequest.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 인증코드 확인
    @PostMapping("/mailconfirm")
    public ResponseEntity<Void> confirmAuthenticationCode(@RequestBody AuthenticationCodeReq authenticationCode) {
        emailService.confirmAuthenticationCode(authenticationCode.getCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.OK);
    }

    // 토큰 재발급
    @PatchMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(@RequestHeader("RefreshToken") String refreshToken){
        return new ResponseEntity<>(reissueTokenService.reissue(refreshToken), HttpStatus.CREATED);
    }

    // 이메일을 통해 아이디 찾기
    @GetMapping("/search/id")
    public ResponseEntity<SearchIDResponse> searchID(@RequestBody SearchIDRequest searchIDRequest) throws MessagingException, UnsupportedEncodingException {
        emailService.sendId(searchIDRequest.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // id 를 통해 비밀번호 찾기
    @GetMapping("/search/pw")
    public ResponseEntity<SearchPWResponse> searchPW(@RequestBody SearchPWRequest searchPWRequest) {
        return new ResponseEntity<>(searchPWService.searchPW(searchPWRequest), HttpStatus.OK);
    }
}
