package com.real.realoasis.domain.couple.presenattion;

import com.real.realoasis.domain.couple.service.EnterDatingDateService;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;
import com.real.realoasis.domain.couple.service.MainPageService;
import com.real.realoasis.domain.user.util.MainPageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couple")
@RequiredArgsConstructor
public class CoupleController {
    private final MainPageService mainPageService;
    private final EnterDatingDateService enterDatingDateService;
    private final MainPageConverter mainPageConverter;

    @GetMapping
    public ResponseEntity<MainPageResponse> getMainPage(){
        MainPageResponse mainPageResponse = mainPageService.getMainPage();
        return new ResponseEntity<>( mainPageResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> datingDateEnter(@RequestBody DatingDateEnterRequest datingDateEnterRequest){
        EnterDto enterDto = mainPageConverter.toEnterDto(datingDateEnterRequest);
        enterDatingDateService.enter(enterDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
