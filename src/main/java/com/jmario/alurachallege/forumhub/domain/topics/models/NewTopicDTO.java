package com.jmario.alurachallege.forumhub.domain.topics.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewTopicDTO(
        @NotBlank
        String title,

        @NotBlank
        String message,

        @NotNull
        Long author_id,

        @NotNull
        Long course_id

){
}
