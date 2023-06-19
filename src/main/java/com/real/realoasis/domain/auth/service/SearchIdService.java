package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.data.dto.SearchIdDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface SearchIdService {
    void send(SearchIdDto searchIdDto) throws MessagingException, UnsupportedEncodingException;
}
