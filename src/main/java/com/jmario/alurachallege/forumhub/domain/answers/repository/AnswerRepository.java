package com.jmario.alurachallege.forumhub.domain.answers.repository;


import com.jmario.alurachallege.forumhub.domain.answers.models.Answer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {


    boolean existsByTopicIdAndAuthorIdAndMessage(Long topicId,Long authorId,String message);

    List<Answer> findAllByTopicId(Long topicId);
}
