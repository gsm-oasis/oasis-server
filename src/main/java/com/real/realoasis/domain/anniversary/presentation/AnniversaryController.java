package com.real.realoasis.domain.anniversary.presentation;

import com.real.realoasis.domain.anniversary.presentation.data.dto.AnniversaryListDto;
import com.real.realoasis.domain.anniversary.presentation.data.response.AnniversaryListResponse;
import com.real.realoasis.domain.anniversary.service.AddAnniversaryDateService;
import com.real.realoasis.domain.anniversary.service.GetAnniversaryListService;
import com.real.realoasis.domain.anniversary.util.AnniversaryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anniversary")
public class AnniversaryController {
    private final AddAnniversaryDateService addAnniversaryDateService;
    private final GetAnniversaryListService getAnniversaryListService;
    private final AnniversaryConverter anniversaryConverter;

    // 기념일 추가
    @PostMapping
    public ResponseEntity<Void> addAnniversaryDate(@RequestParam("anniversaryDate") String anniversaryDate) {
        addAnniversaryDateService.add(anniversaryDate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 기념일 목록
    @GetMapping
    public ResponseEntity<List<AnniversaryListResponse>> getAnniversaryList() {
        List<AnniversaryListDto> anniversaryListDtoList = getAnniversaryListService.get();
        List<AnniversaryListResponse> anniversaryListResponseList = anniversaryListDtoList.stream()
                .map(anniversaryConverter::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(anniversaryListResponseList, HttpStatus.OK);
    }
}
