package com.learning.jpaRelationships.service;

import com.learning.jpaRelationships.model.Profile;
import com.learning.jpaRelationships.model.User;
import com.learning.jpaRelationships.repository.ProfileRepository;
import com.learning.jpaRelationships.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @PersistenceContext
    EntityManager entityManager;
    ProfileRepository profileRepository;
    UserRepository userRepository;
    public ProfileService(
            ProfileRepository profileRepository,
            UserRepository userRepository
    ) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createProfile(
            Profile profile,
            String userName
    ) {
        User user = new User();
        user.setName(userName);
        user.setProfile(profile);
        userRepository.save(user);
        profile.setUser(user);
        profileRepository.save(profile);
    }

    @Transactional
    public void createProfile(Profile profile, Long id) {
        User user = userRepository.getUserById(id);
        Profile oldProfile = user.getProfile();
        if(oldProfile != null) {
            oldProfile.setUser(null);
            user.setProfile(null);
            entityManager.flush();
        }
        profile.setUser(user);
        user.setProfile(profile);
        profileRepository.save(profile);
        userRepository.save(user);
    }
}
