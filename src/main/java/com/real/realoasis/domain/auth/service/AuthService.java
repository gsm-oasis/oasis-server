package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.dto.LoginDto;
import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.request.SearchPWRequest;
import com.real.realoasis.domain.auth.data.response.LoginResponse;
import com.real.realoasis.domain.auth.data.response.SearchPWResponse;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.auth.data.response.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginDto loginDto);
    TokenResponse reissue(String refreshToken);
    SearchPWResponse searchPW(SearchPWRequest searchPWRequest);
    SignupResponse signUp(SignupDto signupDto);


}
