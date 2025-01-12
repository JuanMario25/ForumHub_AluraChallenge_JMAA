package com.jmario.alurachallege.forumhub.domain.courses.models;

import com.jmario.alurachallege.forumhub.domain.courses.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddCourseDTO(
        @NotBlank
        String name,
        @NotNull
        Category category
) {
}
