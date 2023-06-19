package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.data.dto.PasswordChangeDto;

public interface UpdatePasswordService {
    void update(PasswordChangeDto passwordChangeDto);
}
