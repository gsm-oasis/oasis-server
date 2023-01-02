package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.data.dto.SignupDto;
import com.real.realoasis.domain.auth.data.request.SignUpRequest;
import com.real.realoasis.domain.auth.data.response.SignupResponse;
import com.real.realoasis.domain.user.entity.User;

public interface AuthConverter {
    SignupDto toSignupDto(SignUpRequest signupRequest);

    User toEntity(SignupDto signupDto);

    SignupResponse toSignResponse(String code);
}
