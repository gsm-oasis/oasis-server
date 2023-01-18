package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.dto.LoginDto;
import com.real.realoasis.domain.auth.data.dto.SearchPwDto;
import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.data.response.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginDto loginDto);
    TokenResponse reissue(String refreshToken);
    void searchPW(SearchPwDto searchPwDto);
    SignupResponse signUp(SignupDto signupDto);


}
