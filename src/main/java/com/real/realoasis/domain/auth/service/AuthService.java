package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.request.LoginRequest;
import com.real.realoasis.domain.auth.data.request.SearchPWRequest;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.LoginResponse;
import com.real.realoasis.domain.auth.data.response.SearchPWResponse;
import com.real.realoasis.domain.auth.data.response.SignupResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse reissue(String refreshToken);
    SearchPWResponse searchPW(SearchPWRequest searchPWRequest);
    SignupResponse signUp(SignupDto signupDto);


}
