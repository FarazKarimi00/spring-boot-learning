package com.learning.jpaRelationships.repository;

import com.learning.jpaRelationships.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }
}
