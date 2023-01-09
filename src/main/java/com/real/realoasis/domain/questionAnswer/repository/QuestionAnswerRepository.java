package com.real.realoasis.domain.questionAnswer.repository;

import com.real.realoasis.domain.question.entity.Question;
import com.real.realoasis.domain.questionAnswer.entity.QuestionAnswer;
import com.real.realoasis.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    QuestionAnswer findQuestionAnswersByQuestionAndUser(Question question, User user);

    List<QuestionAnswer> findAllByUserId(String userId);
}
