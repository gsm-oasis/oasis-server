package com.real.realoasis.domain.questionAnswer.repository;

import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    QuestionAnswer findQuestionAnswerByQuestionIdAndUserId(Long questionId, String userId);
}
