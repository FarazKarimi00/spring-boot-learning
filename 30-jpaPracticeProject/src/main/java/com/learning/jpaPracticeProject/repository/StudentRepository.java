package com.learning.jpaPracticeProject.repository;

import com.learning.jpaPracticeProject.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student find(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager.createQuery(
                "SELECT s FROM Student s " +
                        "LEFT JOIN FETCH s.department " +
                        "LEFT JOIN FETCH s.profile",
                Student.class
        ).getResultList();
    }

    public Student update(Student student) {
        return entityManager.merge(student);
    }

    public void remove(Student student) {
        entityManager.remove(student);
    }
}
