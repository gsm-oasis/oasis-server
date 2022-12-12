package com.real.realoasis.domain.question.repository;

import com.real.realoasis.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findQuestionById(Long questionId);
}
