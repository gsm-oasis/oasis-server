package com.real.realoasis.domain.auth.presentation;

import com.real.realoasis.domain.auth.presentation.dto.request.AuthenticationCodeReq;
import com.real.realoasis.domain.auth.presentation.dto.request.LoginRequest;
import com.real.realoasis.domain.user.presentation.dto.request.SearchIDRequest;
import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.LoginResponse;
import com.real.realoasis.domain.auth.presentation.dto.response.ReissueTokenResponse;
import com.real.realoasis.domain.user.presentation.dto.response.SearchIDResponse;
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
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest signupRequest) throws MessagingException, UnsupportedEncodingException {
        signUpService.signUp(signupRequest);
        emailService.sendEmail(signupRequest.getEmail());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 이메일 인증
    @PostMapping("/mailconfirm")
    public ResponseEntity<Void> confirmAuthenticationCode(@RequestBody AuthenticationCodeReq authenticationCode) {
        emailService.confirmAuthenticationCode(authenticationCode.getAuthenticationCode());
        return new ResponseEntity<>(HttpStatus.OK);
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

    // 이메일을 통해 아이디 찾기
    @PostMapping("/search/id")
    public ResponseEntity<SearchIDResponse> searchID(@RequestBody SearchIDRequest searchIDRequest) throws MessagingException, UnsupportedEncodingException {
        emailService.sendId(searchIDRequest.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
