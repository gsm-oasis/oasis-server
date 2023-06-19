package com.real.realoasis.domain.auth.service;

public interface ConfirmAuthCodeService {
    void confirmAuthenticationCode(String code, String sentCode);
}
