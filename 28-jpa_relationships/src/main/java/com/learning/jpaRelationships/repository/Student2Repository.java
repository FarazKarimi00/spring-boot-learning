package com.learning.jpaRelationships.repository;

import com.learning.jpaRelationships.model.Student2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class Student2Repository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Student2 student) {
        entityManager.persist(student);
    }
}
