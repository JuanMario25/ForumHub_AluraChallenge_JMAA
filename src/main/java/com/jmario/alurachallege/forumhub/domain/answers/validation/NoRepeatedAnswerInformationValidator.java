package com.jmario.alurachallege.forumhub.domain.answers.validation;

import com.jmario.alurachallege.forumhub.domain.answers.models.NewAnswerDTO;
import com.jmario.alurachallege.forumhub.domain.answers.repository.AnswerRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoRepeatedAnswerInformationValidator implements AnswerValidator {
    @Autowired
    private AnswerRepository answerRepository;

    @Override

    public void validate(NewAnswerDTO newAnswer) {
        boolean repeatedInfo = answerRepository.existsByTopicIdAndAuthorIdAndMessage(newAnswer.topic_id(),newAnswer.author_id(), newAnswer.message());
        if(repeatedInfo){
            throw new ValidationFailureException("This information already exist");
        }
    }
}
