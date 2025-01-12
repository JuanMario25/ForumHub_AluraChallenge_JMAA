package com.jmario.alurachallege.forumhub.domain.topics.models;

import com.jmario.alurachallege.forumhub.domain.courses.models.Course;
import com.jmario.alurachallege.forumhub.domain.topics.enums.Status;
import com.jmario.alurachallege.forumhub.domain.users.models.User;

import java.time.LocalDateTime;

public record TopicDetails(
        String title,
        String message,
        LocalDateTime datetime,
        Status status,
        String author,
        String course
) {
    public TopicDetails(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getDateTimeStamp(),topic.getStatus(), topic.getAuthor().getName(),topic.getCourse().getName());
    }
}
