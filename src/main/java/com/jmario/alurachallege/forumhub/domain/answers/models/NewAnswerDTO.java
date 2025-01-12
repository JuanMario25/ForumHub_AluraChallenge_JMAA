package com.jmario.alurachallege.forumhub.domain.answers.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewAnswerDTO(
        @NotBlank
        String message,
        @NotNull
        Long topic_id,
        @NotNull
        Long author_id
) {
}
