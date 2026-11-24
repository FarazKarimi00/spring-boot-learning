package com.learning.springSecurity.controller;

import com.learning.springSecurity.dto.UserRegisterRequestDTO;
import com.learning.springSecurity.dto.UserRegisterResponseDTO;
import com.learning.springSecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.function.BooleanSupplier;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

//    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/hello")
    public String sayHello() {
//        System.out.println(passwordEncoder.encode("secret123"));
//        System.out.println(passwordEncoder.encode("secret123"));
//        System.out.println(passwordEncoder.matches(
//                "secret123",
//                "$2a$10$uurQmLJVYyFiTO123xDgEuXxNIs6XH8jx0fTpoea/BxNW4ooPAK/K"
//        ));
//        System.out.println(passwordEncoder.matches(
//                "secret123",
//                "$2a$10$QkJ.pJ3BLIeA9J22JVKMbOsa4uDmh3WuvWj7StiBmuzYj1oqBGk7i"
//        ));
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDTO> register(@RequestBody UserRegisterRequestDTO userRegisterRequest) {
        UserRegisterResponseDTO userRegisterResponse = authService.registerUser(userRegisterRequest);
        return ResponseEntity.ok(userRegisterResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserRegisterRequestDTO userRegisterRequest) {
        boolean loggedIn = authService.login(userRegisterRequest);
        return ResponseEntity.ok(loggedIn);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
