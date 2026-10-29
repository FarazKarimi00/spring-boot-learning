package com.learning.hibernateInternals.repository;

import com.learning.hibernateInternals.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // CREATE
    public void save(Student student) {
        entityManager.persist(student);
    }

    // SAVE ALL (Batch processing pattern)
    public void saveAll(List<Student> studentList) {
        int counter = 0;
        for(Student student : studentList) {
            entityManager.persist(student);
            counter++;
            if (counter % 100 == 0) {
                entityManager.flush();
                entityManager.clear();
                // entityManager.refresh(student);
            }
        }
        if(counter % 100 != 0) {
            entityManager.flush();
            entityManager.clear();
        }
    }

    // READ
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // DELETE
    public void remove(Student student) {
        entityManager.remove(student);
    }

    public Student attachAgain(Student student) {
        return entityManager.merge(student);
    }
    public void detach(Student student) {
        entityManager.detach(student);
    }
    public void flush() {
        entityManager.flush();
    }
}

