package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.data.request.PasswordChangeRequest;

public interface PasswordChangeService {
    void passwordChange(PasswordChangeRequest passwordChangeRequest);
}
