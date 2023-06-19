package com.real.realoasis.domain.questionAnswer.domain.repository;

import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    QuestionAnswer findQuestionAnswerByQuestionIdxAndUserIdx(Long questionId, Long userId);

    List<QuestionAnswer> findAllByUserIdx(Long userIdx);
}
