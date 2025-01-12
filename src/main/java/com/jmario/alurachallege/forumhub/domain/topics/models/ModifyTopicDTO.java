package com.jmario.alurachallege.forumhub.domain.topics.models;

import com.jmario.alurachallege.forumhub.domain.topics.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModifyTopicDTO(
        @NotNull
        Long topic_id,
        String title,
        String message,
        Status status,
        // in case status would be set Close
        // must be select the answer that solve the answer
        // if not winner_answer_id might be null
        Long winner_answer_id


){
}
