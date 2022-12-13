package com.real.realoasis.domain.questionAnswer.repository;

import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    Optional<QuestionAnswer> findQuestionById(Long questionId);
}
