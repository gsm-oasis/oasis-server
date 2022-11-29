package com.real.realoasis.domain.auth.presentation;

import com.real.realoasis.domain.auth.presentation.dto.request.SignUpRequest;
import com.real.realoasis.domain.auth.service.LoginService;
import com.real.realoasis.domain.auth.service.SignUpService;
import com.real.realoasis.domain.auth.service.ReissueTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;
    private final SignUpService signUpService;
    private final ReissueTokenService reissueTokenService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signupRequest){
        signUpService.signUp(signupRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
