package com.learning.jpaRelationships.repository;

import com.learning.jpaRelationships.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Course course) {
        entityManager.persist(course);
    }

    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }
}
