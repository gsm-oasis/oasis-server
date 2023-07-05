package com.real.realoasis.domain.questionAnswer.presentation;

import com.real.realoasis.domain.questionAnswer.presentation.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.dto.QuestionAnswerListDto;
import com.real.realoasis.domain.questionAnswer.presentation.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.presentation.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.service.GetMainPageService;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerListService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionAnswerController {
    private final CreateQuestionAnswerService createQuestionAnswerService;
    private final GetMainPageService getMainPageService;
    private final GetQuestionAnswerListService getQuestionAnswerListService;
    private final QuestionAnswerConverter questionAnswerConverter;

    @PostMapping("/{questionId}")
    public ResponseEntity<Void> createAnswer(@PathVariable Long questionId, @RequestBody QuestionAnswerWriteRequest questionAnswerRequest){
        CreateDto createDto = questionAnswerConverter.toDto(questionAnswerRequest);
        createQuestionAnswerService.createQuestionAnswer(createDto, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionAnswerResponse> getMainpage(@PathVariable Long questionId){
        QuestionAnswerResponse questionAnswerResponse = getMainPageService.getMainpage(questionId);
        return new ResponseEntity<>(questionAnswerResponse, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<QuestionAnswerListResponse>> getListPage(){
        List<QuestionAnswerListDto> questionAnswerListDtoList = getQuestionAnswerListService.getList();
        List<QuestionAnswerListResponse> questionAnswerListResponse = questionAnswerListDtoList.stream()
                .map(questionAnswerConverter::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(questionAnswerListResponse, HttpStatus.OK);
    }

}
