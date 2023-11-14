package com.example.authservice.controllers;

import com.example.authservice.dtos.*;
import com.example.authservice.models.Session;
import com.example.authservice.models.User;
import com.example.authservice.services.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
private AuthService authService;

    @PostMapping("/login")
    @Transactional
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO  = new LoginResponseDTO();
        try {
            User user = authService.login(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
            Session session = authService.createSession(user);

            UserDTO userDTO = new UserDTO();
            userDTO.setToken(session.getToken());
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());

            loginResponseDTO.setUser(userDTO);
            loginResponseDTO.setSuccess(true);
        }
        catch (Exception e) {
            loginResponseDTO.setSuccess(false);
            loginResponseDTO.setError(e.getMessage());
        }
        return loginResponseDTO;
    }

    @PostMapping("/signup")
    public SignUpResponseDTO signup(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        try {
            User user = authService.signup(signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
            Session session = authService.createSession(user);
            UserDTO userDTO = new UserDTO();
            userDTO.setToken(session.getToken());
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
            signUpResponseDTO.setUser(userDTO);
            signUpResponseDTO.setSuccess(true);
        }
        catch (Exception e) {
            signUpResponseDTO.setSuccess(false);
            signUpResponseDTO.setError(e.getMessage());
        }
        return signUpResponseDTO;
    }



}
