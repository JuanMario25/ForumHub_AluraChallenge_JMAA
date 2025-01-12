package com.jmario.alurachallege.forumhub.domain.topics.validation;

import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoRepeatedTopicMessageValidator implements TopicValidator{
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(NewTopicDTO newTopic) {
        boolean repeatedMessage = topicRepository.existsByMessage(newTopic.message());
        if(repeatedMessage){
            throw new ValidationFailureException("This message already exists");
        }
    }
}
