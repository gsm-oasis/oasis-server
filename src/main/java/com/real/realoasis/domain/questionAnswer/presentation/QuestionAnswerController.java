package com.real.realoasis.domain.questionAnswer.presentation;

import com.real.realoasis.domain.questionAnswer.presentation.dto.request.QuestionAnswerRequest;
import com.real.realoasis.domain.questionAnswer.service.CreateQuestionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionAnswerController {
    private final CreateQuestionAnswerService createQuestionAnswerService;

    @PostMapping("/answer/{questionId}")
    public ResponseEntity<Void> createAnswer(@PathVariable Long questionId, @RequestBody QuestionAnswerRequest questionAnswerRequest){
        createQuestionAnswerService.createQuestionAnswer(questionAnswerRequest, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
