package com.jmario.alurachallege.forumhub.domain.topics.validation;

import com.jmario.alurachallege.forumhub.domain.courses.repository.CourseRepository;
import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsCourseValidator implements TopicValidator {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public void validate(NewTopicDTO newTopic) {
        boolean existsCourse = courseRepository.existsById(newTopic.course_id());
        if(!existsCourse){
            throw new ValidationFailureException("This Course is not available");
        }
    }
}
