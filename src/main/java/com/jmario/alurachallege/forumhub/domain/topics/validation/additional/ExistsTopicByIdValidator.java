package com.jmario.alurachallege.forumhub.domain.topics.validation.additional;

import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsTopicByIdValidator {
    @Autowired
    private TopicRepository topicRepository;

    public void validate(Long id){
        if(!topicRepository.existsById(id)) throw new ValidationFailureException("This topic does not exist or It has been deleted");
    }
}
