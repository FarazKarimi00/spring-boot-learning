package com.learning.jpaRelationships.controller;

import com.learning.jpaRelationships.model.User;
import com.learning.jpaRelationships.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/withProfile")
    public ResponseEntity<String> createUser(
            @RequestBody User user,
            @RequestParam String profile
    ) {
        userService.createUser(user, profile);
        return ResponseEntity.ok("User created");
    }
    @PostMapping("/{profileId}")
    public ResponseEntity<String> createUser(
            @RequestBody User user,
            @PathVariable Long profileId
    ) {
        userService.createUser(user, profileId);
        return ResponseEntity.ok("User created");
    }
}
