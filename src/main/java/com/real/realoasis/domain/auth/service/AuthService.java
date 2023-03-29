package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.*;

public interface AuthService {
    TokenDto login(LoginDto loginDto);
    TokenDto reissue(String refreshToken);
    void searchPW(SearchPwDto searchPwDto);
    CoupleCodeDto signUp(SignupDto signupDto);


}
