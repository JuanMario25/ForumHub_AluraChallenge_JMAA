package com.jmario.alurachallege.forumhub.domain.users.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserSingUpDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password) {
}
