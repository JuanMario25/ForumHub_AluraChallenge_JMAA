package com.jmario.alurachallege.forumhub.domain.courses.models;

import com.jmario.alurachallege.forumhub.domain.courses.enums.Category;

public record CourseDetails(
        String name,
        Category category
) {
    public CourseDetails(Course course){
        this(course.getName(),course.getCategory());
    }
}
