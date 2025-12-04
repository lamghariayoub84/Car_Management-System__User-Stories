package com.auth.auth_service.dto;

import com.auth.auth_service.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class RegisterDto {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
