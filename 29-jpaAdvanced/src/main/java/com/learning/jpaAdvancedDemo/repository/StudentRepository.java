package com.learning.jpaAdvancedDemo.repository;

import com.learning.jpaAdvancedDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }


    public Student fetch(Long id) {
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
}

