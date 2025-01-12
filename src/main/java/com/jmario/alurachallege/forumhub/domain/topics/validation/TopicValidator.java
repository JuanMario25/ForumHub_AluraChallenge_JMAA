package com.jmario.alurachallege.forumhub.domain.topics.validation;

import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;

public interface TopicValidator {
    void validate(NewTopicDTO newTopic);
}
