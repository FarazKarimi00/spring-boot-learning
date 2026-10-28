package com.learning.hibernateFundamentals.repository;

import com.learning.hibernateFundamentals.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // CREATE
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    // READ
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // DELETE
    public void remove(Student student) {
        entityManager.remove(student);
    }
}

