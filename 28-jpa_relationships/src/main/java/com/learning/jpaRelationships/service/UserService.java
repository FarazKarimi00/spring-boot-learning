package com.learning.jpaRelationships.service;

import com.learning.jpaRelationships.model.Profile;
import com.learning.jpaRelationships.model.User;
import com.learning.jpaRelationships.repository.ProfileRepository;
import com.learning.jpaRelationships.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    ProfileRepository profileRepository;
    public UserService(
            UserRepository userRepository,
            ProfileRepository profileRepository
    ) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createUser(User user, String userProfile) {
        userRepository.save(user);

        Profile profile = new Profile();
        profile.setBio(userProfile);
        profile.setUser(user);
        profileRepository.save(profile);

        user.setProfile(profile);
    }

    @Transactional
    public void createUser(User user, Long profileId) {
        Profile profile = profileRepository.getProfileById(profileId);
        user.setProfile(profile);
        profile.setUser(user);
        userRepository.save(user);
    }
}
//        Profile profile = new Profile();
//        profile.setBio(userProfile);
//        profile.setUser(user);
//        profileRepository.save(profile);
//        user.setProfile(profile);
//        userRepository.save(user);
