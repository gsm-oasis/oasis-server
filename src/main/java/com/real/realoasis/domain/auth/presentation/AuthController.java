package com.real.realoasis.domain.auth.presentation;

import com.real.realoasis.domain.auth.presentation.data.dto.*;
import com.real.realoasis.domain.auth.presentation.data.request.*;
import com.real.realoasis.domain.auth.presentation.data.response.SendAuthCodeResponse;
import com.real.realoasis.domain.auth.presentation.data.response.SignupResponse;
import com.real.realoasis.domain.auth.presentation.data.response.RefreshTokenResponse;
import com.real.realoasis.domain.auth.presentation.data.response.TokenResponse;
import com.real.realoasis.domain.auth.service.*;
import com.real.realoasis.domain.auth.util.AuthConverter;
import com.real.realoasis.domain.auth.util.MailConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;
    private final ReissueService reissueService;
    private final SearchPasswordService searchPasswordService;
    private final SignUpService signUpService;
    private final ConfirmAuthCodeService confirmAuthenticationCode;
    private final SendAuthCodeService sendAuthCodeService;
    private final SearchIdService searchIdService;
    private final AuthConverter authConverter;
    private final MailConverter mailConverter;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signupRequest){
        SignupDto signupDto = authConverter.toDto(signupRequest);
        signUpService.signUp(signupDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 이메일에 인증코드 전송
    @PostMapping("/email")
    public ResponseEntity<Void> sendEmail(@RequestParam("email") String email) throws MessagingException, UnsupportedEncodingException {
        SendAuthCodeDto sendAuthCodeDto = sendAuthCodeService.send(email);
        mailConverter.toResponse(sendAuthCodeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 인증코드 확인
    @GetMapping("/code")
    public ResponseEntity<Void> confirmAuthenticationCode(@RequestParam("email") String email, @RequestParam("code")String code) {
        confirmAuthenticationCode.confirmAuthenticationCode(email, code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginDto loginDto = authConverter.toDto(loginRequest);
        TokenDto tokenDto = loginService.login(loginDto);
        TokenResponse tokenResponse = authConverter.toResponse(tokenDto);
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }

    // 토큰 재발급
    @PatchMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> reissue(@RequestHeader("RefreshToken") String refreshToken){
        RefreshTokenDto refreshTokenDto = reissueService.reissue(refreshToken);
        RefreshTokenResponse tokenResponse = authConverter.toResponse(refreshTokenDto);
        return new ResponseEntity<>(tokenResponse, HttpStatus.CREATED);
    }

    // 이메일을 통해 아이디 찾기
    @PostMapping("/id")
    public ResponseEntity<Void> searchID(@RequestBody SearchIdRequest searchIDRequest) throws MessagingException, UnsupportedEncodingException {
        SearchIdDto searchIdDto = mailConverter.toDto(searchIDRequest);
        searchIdService.send(searchIdDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // id 를 통해 비밀번호 찾기
    @PatchMapping ("/password")
    public ResponseEntity<Void> searchPW(@RequestBody SearchPwRequest searchPWRequest) {
        SearchPwDto searchPwDto = authConverter.toDto(searchPWRequest);
        searchPasswordService.searchPW(searchPwDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
