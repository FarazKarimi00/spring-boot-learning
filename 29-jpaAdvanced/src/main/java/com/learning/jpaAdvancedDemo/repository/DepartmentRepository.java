package com.learning.jpaAdvancedDemo.repository;

import com.learning.jpaAdvancedDemo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department find(Long id) {
        return entityManager.find(Department.class, id);
    }

    public void removeDepartment(Department department) {
        entityManager.remove(department);
    }
}
