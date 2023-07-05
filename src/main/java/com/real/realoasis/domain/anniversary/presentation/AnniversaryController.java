package com.real.realoasis.domain.anniversary.presentation;

import com.real.realoasis.domain.anniversary.service.AddAnniversaryDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anniversary")
public class AnniversaryController {
    private final AddAnniversaryDateService addAnniversaryDateService;

    // 기념일 추가
    @PostMapping
    public ResponseEntity<Void> addAnniversaryDate(@RequestParam("anniversaryDate") String anniversaryDate) {
        addAnniversaryDateService.add(anniversaryDate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
