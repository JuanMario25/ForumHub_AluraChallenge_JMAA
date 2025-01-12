package com.jmario.alurachallege.forumhub.domain.answers.validation;

import com.jmario.alurachallege.forumhub.domain.answers.models.NewAnswerDTO;
import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsTopicValidator implements AnswerValidator {
    @Autowired
    TopicRepository topicRepository;

    @Override
    public void validate(NewAnswerDTO newAnswer) {
        boolean existsTopic = topicRepository.existsById(newAnswer.topic_id());
        if(!existsTopic){
            throw new ValidationFailureException("This Topic doesn't exists");
        }
    }
}
