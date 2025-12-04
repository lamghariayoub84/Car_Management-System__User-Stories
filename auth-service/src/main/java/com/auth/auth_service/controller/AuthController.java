package com.auth.auth_service.controller;

import com.auth.auth_service.dto.LoginDto;
import com.auth.auth_service.dto.RegisterDto;
import com.auth.auth_service.model.Role;
import com.auth.auth_service.model.User;
import com.auth.auth_service.repository.UserRepository;
import com.auth.auth_service.serice.AuthService;
import com.auth.auth_service.serice.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthService authService;


    @PostMapping("/register")
    public User register(@RequestBody RegisterDto dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto dto) {
        return authService.login(dto);
    }
}

