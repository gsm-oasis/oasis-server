package com.real.realoasis.domain.question.domain.repository;

import com.real.realoasis.domain.question.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findQuestionByIdx(Long idx);
}
