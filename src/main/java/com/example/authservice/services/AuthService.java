package com.example.authservice.services;

import com.example.authservice.exceptions.AuthorizationException;
import com.example.authservice.exceptions.InvalidCredentialException;
import com.example.authservice.exceptions.UserAlreadyExistException;
import com.example.authservice.models.Session;
import com.example.authservice.models.User;

public interface AuthService {
    User login(String email,String password) throws InvalidCredentialException;

    User signup(String email, String password) throws UserAlreadyExistException;

    Session createSession(User user);

    boolean validateToken(String token) throws AuthorizationException;
}
