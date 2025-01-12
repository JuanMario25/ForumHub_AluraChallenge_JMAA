package com.jmario.alurachallege.forumhub.domain.courses.controller;

import com.jmario.alurachallege.forumhub.domain.courses.models.AddCourseDTO;

import com.jmario.alurachallege.forumhub.domain.courses.models.CourseDetails;
import com.jmario.alurachallege.forumhub.domain.courses.service.CourseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@SecurityRequirement(name = "bearer-key")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    @Transactional
    public ResponseEntity<CourseDetails> createNewTopic(@RequestBody @Valid AddCourseDTO course){
        CourseDetails newCourseDetails = courseService.createNewCourse(course);
        return ResponseEntity.ok(newCourseDetails);
    }

}
