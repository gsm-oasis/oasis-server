package com.real.realoasis.domain.question.presentation;

import com.real.realoasis.domain.question.presentation.dto.request.QuestionAnswerRequest;
import com.real.realoasis.domain.question.service.CreateAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final CreateAnswerService createAnswerService;

    @PostMapping("/{questionId}")
    public ResponseEntity<Void> createAnswer(@PathVariable Long questionId, @RequestBody QuestionAnswerRequest questionAnswerRequest){
        createAnswerService.createAnswer(questionAnswerRequest, questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
