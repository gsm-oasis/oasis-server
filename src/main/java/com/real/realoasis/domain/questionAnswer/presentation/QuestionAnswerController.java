package com.real.realoasis.domain.questionAnswer.presentation;

import com.real.realoasis.domain.questionAnswer.presentation.dto.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerListService;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerMainpageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionAnswerController {
    private final CreateQuestionAnswerService createQuestionAnswerService;
    private final GetQuestionAnswerMainpageService getQuestionAnswerMainpageService;
    private final GetQuestionAnswerListService getQuestionAnswerListService;

    @PostMapping("/answer/{questionId}")
    public ResponseEntity<Void> createAnswer(@PathVariable Long questionId, @RequestBody QuestionAnswerWriteRequest questionAnswerRequest){
        createQuestionAnswerService.createQuestionAnswer(questionAnswerRequest, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionAnswerResponse> getMainpage(@PathVariable Long questionId){
        QuestionAnswerResponse questionAnswerResponse = getQuestionAnswerMainpageService.getMainpage(questionId);
        return new ResponseEntity<>(questionAnswerResponse, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Stream<QuestionAnswerListResponse>> getListPage(){
        return new ResponseEntity<>(getQuestionAnswerListService.getList(), HttpStatus.OK);
    }

}
