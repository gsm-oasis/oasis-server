package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.data.dto.MailDto;
import com.real.realoasis.domain.auth.data.request.SendMailRequest;

public interface MailConverter {
    MailDto toDto(SendMailRequest sendMailRequest);
}
