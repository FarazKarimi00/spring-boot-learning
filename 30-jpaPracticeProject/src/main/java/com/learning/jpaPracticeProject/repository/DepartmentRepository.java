package com.learning.jpaPracticeProject.repository;

import com.learning.jpaPracticeProject.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Department save(Department department) {
        entityManager.persist(department);
        return department;
    }

    public Department find(Long id) {
        return entityManager.find(Department.class, id);
    }

    public List<Department> findAll() {
        return entityManager.createQuery(
                "SELECT DISTINCT d " +
                        "FROM Department d " +
                        "LEFT JOIN FETCH d.studentList",
                Department.class
        ).getResultList();
    }

    public Department update(Department department) {
        return entityManager.merge(department);
    }

    public void remove(Department department) {
        entityManager.remove(department);
    }
}

