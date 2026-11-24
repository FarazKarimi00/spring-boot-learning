package com.learning.springSecurity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterResponseDTO {
    private String username;
    private String message;
}
