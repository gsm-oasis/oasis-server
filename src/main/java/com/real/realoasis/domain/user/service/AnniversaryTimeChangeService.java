package com.real.realoasis.domain.user.service;

import com.real.realoasis.domain.user.presentation.dto.request.AnniversaryTimeChangeRequest;
import org.springframework.stereotype.Service;

public interface AnniversaryTimeChangeService {
    void anniversaryTimeChange(AnniversaryTimeChangeRequest anniversaryTimeChangeRequest);
}
