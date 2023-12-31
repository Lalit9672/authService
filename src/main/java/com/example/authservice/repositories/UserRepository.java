package com.example.authservice.repositories;

import com.example.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findByEmail(String email);
    User findByEmailAndPassword(String email,String password);
}
