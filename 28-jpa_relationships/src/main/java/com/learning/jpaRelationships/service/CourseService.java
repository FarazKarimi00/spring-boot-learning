package com.learning.jpaRelationships.service;

import com.learning.jpaRelationships.model.Course;
import com.learning.jpaRelationships.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
}
