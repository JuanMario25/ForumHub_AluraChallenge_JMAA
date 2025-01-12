package com.jmario.alurachallege.forumhub.domain.topics.validation;

import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;
import com.jmario.alurachallege.forumhub.domain.users.repository.UserRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsTopicAuthorValidator implements TopicValidator {
    @Autowired
    UserRepository userRepository;

    @Override
    public void validate(NewTopicDTO newTopic) {
        boolean existsAuthor = userRepository.existsById(newTopic.author_id());
        if(!existsAuthor){
            throw new ValidationFailureException("This Author is not registered in the database");
        }
    }
}
