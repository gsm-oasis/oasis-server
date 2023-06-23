package com.real.realoasis.domain.auth.service;

public interface ConfirmAuthCodeService {
    void confirmAuthenticationCode(String email, String code);
}
