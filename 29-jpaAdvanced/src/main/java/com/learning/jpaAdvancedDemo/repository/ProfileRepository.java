package com.learning.jpaAdvancedDemo.repository;

import com.learning.jpaAdvancedDemo.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Profile profile) {
        entityManager.persist(profile);
    }
}

