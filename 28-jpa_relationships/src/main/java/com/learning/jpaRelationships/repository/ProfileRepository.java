package com.learning.jpaRelationships.repository;

import com.learning.jpaRelationships.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Profile profile) {
        entityManager.persist(profile);
    }

    public Profile getProfileById(Long id) {
        return entityManager.find(Profile.class, id);
    }
}
