package com.learning.jpaRelationships.service;

import com.learning.jpaRelationships.model.Course;
import com.learning.jpaRelationships.model.Student2;
import com.learning.jpaRelationships.repository.CourseRepository;
import com.learning.jpaRelationships.repository.Student2Repository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student2Service {
    Student2Repository student2Repository;
    CourseRepository courseRepository;
    public Student2Service(
            Student2Repository student2Repository,
            CourseRepository courseRepository
    ) {
        this.student2Repository = student2Repository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void createStudent2(Student2 student, List<Long> courseIds) {
        System.out.println(student.getCourses());
        for(Long id : courseIds) {
            Course course = courseRepository.getCourseById(id);
            student.getCourses().add(course);
        }
        student2Repository.save(student);
    }
}
