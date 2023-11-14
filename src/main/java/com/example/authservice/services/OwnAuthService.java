package com.example.authservice.services;

import com.example.authservice.exceptions.AuthorizationException;
import com.example.authservice.exceptions.InvalidCredentialException;
import com.example.authservice.exceptions.UserAlreadyExistException;
import com.example.authservice.models.Session;
import com.example.authservice.models.User;
import com.example.authservice.repositories.SessionRepository;
import com.example.authservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OwnAuthService implements AuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;
//    @Override
//    public boolean validate(String token) {
//        Session session = sessionRepository.findSessionByToken(token);
//
//        if(session == null) {
//           return false;
//        }
//        else {
//            return true;
//        }
//    }
//
    @Override
    public User login(String email, String password) throws InvalidCredentialException {
       User user =  userRepository.findByEmailAndPassword(email,password);

       if(user == null) {
           //email and password are wrong
           throw new InvalidCredentialException("Email and Password does not exist");
       }
       return user;
    }

    @Override
    public User signup(String email, String password) throws UserAlreadyExistException {
        if(userRepository.findByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            User savedUser = userRepository.save(user);
            return savedUser;
        }
        else {
            //user already exists
            throw new UserAlreadyExistException("User already exists");
        }

    }

    @Override
    public Session createSession(User user) {
        String token = generateNewToken();
        Session session = new Session();
        session.setUser(user);
        session.setToken(token);
        Session savedSession = sessionRepository.save(session);
        return savedSession;
    }

    @Override
    public boolean validateToken(String tokenValue) throws AuthorizationException{
        Session session  = sessionRepository.existsSessionByToken(tokenValue);
        if(session == null) {
            throw new AuthorizationException("Invalid Token");
        }
        return true;
    }

    private String generateNewToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 20);
    }
}
