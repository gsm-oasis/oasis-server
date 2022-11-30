package com.real.realoasis.domain.auth.presentation;

import com.real.realoasis.domain.auth.presentation.dto.request.EmailAuthRequestDto;
import com.real.realoasis.domain.auth.presentation.dto.request.LoginRequest;
import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.LoginResponse;
import com.real.realoasis.domain.auth.presentation.dto.response.ReissueTokenResponse;
import com.real.realoasis.domain.auth.service.EmailService;
import com.real.realoasis.domain.auth.service.LoginService;
import com.real.realoasis.domain.auth.service.SignUpService;
import com.real.realoasis.domain.auth.service.ReissueTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;
    private final SignUpService signUpService;
    private final ReissueTokenService reissueTokenService;
    private final EmailService emailService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest signupRequest) {
        signUpService.signUp(signupRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 이메일 인증
    @PostMapping("/signup/mailconfirm")
    public String mailConfirm(@RequestBody EmailAuthRequestDto emailDto) throws MessagingException, UnsupportedEncodingException {
        return emailService.sendEmail(emailDto.getEmail());
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.OK);
    }

    // 토큰 재발급
    @PutMapping("/refresh")
    public ResponseEntity<ReissueTokenResponse> refresh(@RequestHeader("Refresh") String refreshToken){
        return new ResponseEntity<>(reissueTokenService.reissue(refreshToken), HttpStatus.OK);
    }


}
