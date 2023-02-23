package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.dto.*;
import com.real.realoasis.domain.auth.data.response.TokenResponse;

public interface AuthService {
    TokenDto login(LoginDto loginDto);
    TokenDto reissue(String refreshToken);
    void searchPW(SearchPwDto searchPwDto);
    AuthCodeDto signUp(SignupDto signupDto);


}
