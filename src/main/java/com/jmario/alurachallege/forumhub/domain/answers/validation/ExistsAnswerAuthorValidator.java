package com.jmario.alurachallege.forumhub.domain.answers.validation;

import com.jmario.alurachallege.forumhub.domain.answers.models.NewAnswerDTO;
import com.jmario.alurachallege.forumhub.domain.users.repository.UserRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsAnswerAuthorValidator implements AnswerValidator {
    @Autowired
    UserRepository userRepository;

    @Override
    public void validate(NewAnswerDTO newAnswer) {
        boolean existsAuthor = userRepository.existsById(newAnswer.author_id());
        if(!existsAuthor){
            throw new ValidationFailureException("This Author is not registered in the database");
        }
    }

}
