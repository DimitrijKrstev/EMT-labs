package com.example.emtlab1.repository;

import com.example.emtlab1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
