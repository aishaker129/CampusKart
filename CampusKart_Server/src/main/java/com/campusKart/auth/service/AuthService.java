package com.campusKart.auth.service;

import com.campusKart.auth.dto.AuthResponse;
import com.campusKart.auth.dto.LoginRequest;
import com.campusKart.auth.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
