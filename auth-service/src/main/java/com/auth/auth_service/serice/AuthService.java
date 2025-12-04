package com.auth.auth_service.serice;


import com.auth.auth_service.dto.LoginDto;
import com.auth.auth_service.dto.RegisterDto;
import com.auth.auth_service.model.User;
import com.auth.auth_service.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService)
    {
        this.userRepository = userRepository;
        this.passwordEncoder =passwordEncoder;
        this.jwtService = jwtService;
    }
    public User register(RegisterDto registerDto)
    {
        if(userRepository.findByUsername(registerDto.getUsername()).isPresent())
        {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(registerDto.getRole());
       return userRepository.save(user);
    }
    public String login(LoginDto loginDto)
    {
        User u=userRepository.findByUsername(loginDto.getUsername()).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        if(!passwordEncoder.matches(loginDto.getPassword(),u.getPassword()))
        {
            throw new RuntimeException("Incorrect password");
        }
        return jwtService.generateToken(u);
    }



}
