package com.learning.jpaRelationships.controller;

import com.learning.jpaRelationships.model.Profile;
import com.learning.jpaRelationships.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spi/profile")
public class ProfileController {
    ProfileService profileService;
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/withUser")
    public ResponseEntity<String> createProfile(
            @RequestBody Profile profile,
            @RequestParam String user
    ) {
        profileService.createProfile(profile, user);
        return ResponseEntity.ok("Profile created");
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> createProfile(
            @RequestBody Profile profile,
            @PathVariable Long userId
    ) {
        profileService.createProfile(profile, userId);
        return ResponseEntity.ok("Profile created");
    }
}
