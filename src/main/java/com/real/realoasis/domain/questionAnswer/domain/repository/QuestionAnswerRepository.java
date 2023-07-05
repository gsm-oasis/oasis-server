package com.real.realoasis.domain.questionAnswer.domain.repository;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.question.domain.entity.Question;
import com.real.realoasis.domain.questionAnswer.domain.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    QuestionAnswer findByQuestionIdxAndCouple(Long questionIdx, Couple couple);
    List<QuestionAnswer> findAllByCouple(Couple couple);
}
