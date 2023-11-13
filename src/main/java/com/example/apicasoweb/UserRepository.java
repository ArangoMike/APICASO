package com.example.apicasoweb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserM, Long> {
    UserM findByUsername(String username);
}

