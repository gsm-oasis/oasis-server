package com.real.realoasis.domain.questionAnswer.presentation;

import com.real.realoasis.domain.questionAnswer.presentation.dto.request.QuestionAnswerWriteRequest;
import com.real.realoasis.domain.questionAnswer.presentation.dto.response.QuestionAnswerResponse;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import com.real.realoasis.domain.questionAnswer.service.GetQuestionAnswerMainpageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionAnswerController {
    private final CreateQuestionAnswerService createQuestionAnswerService;
    private final GetQuestionAnswerMainpageService getQuestionAnswerMainpageService;

    @PostMapping("/answer/{questionId}")
    public ResponseEntity<Void> createAnswer(@PathVariable Long questionId, @RequestBody QuestionAnswerWriteRequest questionAnswerRequest){
        createQuestionAnswerService.createQuestionAnswer(questionAnswerRequest, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionAnswerResponse> getMainpage(@PathVariable Long questionId){
        return new ResponseEntity<>(getQuestionAnswerMainpageService.getMainpage(questionId), HttpStatus.OK);
    }

}
