package com.learning.jpaRelationships.controller;

import com.learning.jpaRelationships.model.Course;
import com.learning.jpaRelationships.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.ok("Course created");
    }
}
