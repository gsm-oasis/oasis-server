package com.real.realoasis.domain.auth.util;

import com.real.realoasis.domain.auth.presentation.data.dto.AuthCodeDto;
import com.real.realoasis.domain.auth.presentation.data.dto.MailDto;
import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;
import com.real.realoasis.domain.auth.presentation.data.request.AuthenticationCodeRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SearchIdRequest;
import com.real.realoasis.domain.auth.presentation.data.request.SendMailRequest;

public interface MailConverter {
    MailDto toDto(SendMailRequest sendMailRequest);
    AuthCodeDto toDto(AuthenticationCodeRequest authenticationCodeRequest);

    SearchIdDto toDto(SearchIdRequest searchIDRequest);
}
