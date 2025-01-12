package com.jmario.alurachallege.forumhub.domain.courses.repository;


import com.jmario.alurachallege.forumhub.domain.courses.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
