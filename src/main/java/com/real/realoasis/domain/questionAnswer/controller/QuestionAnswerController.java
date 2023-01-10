package com.real.realoasis.domain.questionAnswer.controller;

import com.real.realoasis.domain.questionAnswer.data.dto.CreateDto;
import com.real.realoasis.domain.questionAnswer.data.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerListResponse;
import com.real.realoasis.domain.questionAnswer.data.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.QuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.util.QuestionAnswerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionAnswerController {
    private final QuestionAnswerService questionAnswerService;
    private final QuestionAnswerConverter questionAnswerConverter;

    @PostMapping("/answer/{questionId}")
    public ResponseEntity<Void> createAnswer(@PathVariable Long questionId, @RequestBody QuestionAnswerWriteRequest questionAnswerRequest){
        CreateDto createDto = questionAnswerConverter.toDto(questionAnswerRequest);
        questionAnswerService.createQuestionAnswer(createDto, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionAnswerResponse> getMainpage(@PathVariable Long questionId){
        QuestionAnswerResponse questionAnswerResponse = questionAnswerService.getMainpage(questionId);
        return new ResponseEntity<>(questionAnswerResponse, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Stream<QuestionAnswerListResponse>> getListPage(){
        return new ResponseEntity<>(questionAnswerService.getList(), HttpStatus.OK);
    }

}
