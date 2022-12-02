package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.presentation.dto.request.SearchPWRequest;
import com.real.realoasis.domain.auth.presentation.dto.response.SearchPWResponse;

public interface SearchPWService {
    SearchPWResponse searchPW(SearchPWRequest searchPWRequest);
}
