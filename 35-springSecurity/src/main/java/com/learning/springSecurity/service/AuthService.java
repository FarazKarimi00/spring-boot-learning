package com.learning.springSecurity.service;

import com.learning.springSecurity.dto.UserRegisterRequestDTO;
import com.learning.springSecurity.dto.UserRegisterResponseDTO;
import com.learning.springSecurity.entity.User;
import com.learning.springSecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequest) {
        User user = new User();
        user.setUserName(userRegisterRequest.getUsername());
        String encodedPassword = passwordEncoder.encode(userRegisterRequest.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        User registeredUser = userRepository.save(user);
        UserRegisterResponseDTO userResponse = new UserRegisterResponseDTO();
        userResponse.setUsername(registeredUser.getUserName());
        userResponse.setMessage("User registered successfully");

        return userResponse;
    }

    public boolean login(UserRegisterRequestDTO userRegisterRequest) {
        Optional<User> userOptional = userRepository.findByUserName(userRegisterRequest.getUsername());
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found for name: " + userRegisterRequest.getUsername());
        }
        User user = userOptional.get();
        String encodedPassword = user.getPassword();
        return passwordEncoder.matches(userRegisterRequest.getPassword(), encodedPassword);
    }
}


