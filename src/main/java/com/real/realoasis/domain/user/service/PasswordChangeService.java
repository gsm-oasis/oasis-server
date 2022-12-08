package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.dto.request.PasswordChangeRequest;

public interface PasswordChangeService {
    void passwordChange(PasswordChangeRequest passwordChangeRequest);
}
