package com.jmario.alurachallege.forumhub.domain.courses.service;

import com.jmario.alurachallege.forumhub.domain.courses.models.AddCourseDTO;
import com.jmario.alurachallege.forumhub.domain.courses.models.Course;
import com.jmario.alurachallege.forumhub.domain.courses.models.CourseDetails;
import com.jmario.alurachallege.forumhub.domain.courses.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDetails createNewCourse(@Valid AddCourseDTO course) {
        Course newCourse = new Course(null,course.name(),course.category(),null);
        courseRepository.save(newCourse);
        return new CourseDetails(newCourse);
    }
}
