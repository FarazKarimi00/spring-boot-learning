package com.learning.jpaRelationships.repository;

import com.learning.jpaRelationships.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
