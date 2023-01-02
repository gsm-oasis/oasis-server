package com.real.realoasis.domain.auth.service;

import com.real.realoasis.domain.auth.data.request.SearchPWRequest;
import com.real.realoasis.domain.auth.data.response.SearchPWResponse;

public interface SearchPWService {
    SearchPWResponse searchPW(SearchPWRequest searchPWRequest);
}
