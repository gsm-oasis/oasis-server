package com.real.realoasis.domain.questionAnswer.repository;

import com.real.realoasis.domain.questionAnswer.data.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    QuestionAnswer findQuestionAnswerByQuestionIdAndUserId(Long question_id, String user_id);

    List<QuestionAnswer> findAllByUserId(String userId);
}
