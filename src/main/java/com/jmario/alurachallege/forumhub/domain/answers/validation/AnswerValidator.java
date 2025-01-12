package com.jmario.alurachallege.forumhub.domain.answers.validation;

import com.jmario.alurachallege.forumhub.domain.answers.models.NewAnswerDTO;

public interface AnswerValidator {
    void validate(NewAnswerDTO newAnswer);
}
