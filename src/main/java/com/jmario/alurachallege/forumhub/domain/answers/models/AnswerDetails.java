package com.jmario.alurachallege.forumhub.domain.answers.models;

import com.jmario.alurachallege.forumhub.domain.topics.models.Topic;

import java.time.LocalDateTime;

public record AnswerDetails(
        String message,
        LocalDateTime datetime,
        boolean solution,
        String author,
        String topic_title
) {
    public AnswerDetails(Answer answer) {
        this(answer.getMessage(), answer.getDateTimeStamp(),answer.isSolution(), answer.getAuthor().getName(),answer.getTopic().getTitle());
    }
}

