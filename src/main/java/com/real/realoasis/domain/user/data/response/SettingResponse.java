package com.real.realoasis.domain.user.data.response;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class SettingResponse {
    private final long anniversaryDate;
    private final String version;
    private final String myCode;
}
