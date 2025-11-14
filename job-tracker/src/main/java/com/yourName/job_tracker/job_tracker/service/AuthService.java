package com.yourName.job_tracker.job_tracker.service;

import com.yourName.job_tracker.job_tracker.dto.AuthResponse;
import com.yourName.job_tracker.job_tracker.dto.LoginRequest;
import com.yourName.job_tracker.job_tracker.dto.RegisterRequest;
import com.yourName.job_tracker.job_tracker.exception.BadRequestException;
import com.yourName.job_tracker.job_tracker.model.User;
import com.yourName.job_tracker.job_tracker.repository.UserRepository;
import com.yourName.job_tracker.job_tracker.security.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    
    public AuthResponse register(RegisterRequest request) {
        //won't allow duplicate emails
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already registered");
        }
        //won't allow duplicate display names
        if (userRepository.existsByDisplayName(request.getDisplayName())) {
            throw new BadRequestException("Display name already taken");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setDisplayName(request.getDisplayName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, user.getEmail(), user.getDisplayName());
    }
    
    public AuthResponse login(LoginRequest request) {
        //Verifies email
        User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new BadRequestException("Invalid email or password"));
        //Verifies Password by checking hashed password with input
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, user.getEmail(), user.getDisplayName());
    }
    
}
