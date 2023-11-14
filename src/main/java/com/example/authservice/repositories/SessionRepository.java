package com.example.authservice.repositories;

import com.example.authservice.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session,Long> {
    Session existsSessionByToken(String token);
    Session save(Session session);
}
