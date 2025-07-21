package com.campusKart.auth.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterRequest {
    @Email
    private String email;
    private String name;
    private String password;
}
