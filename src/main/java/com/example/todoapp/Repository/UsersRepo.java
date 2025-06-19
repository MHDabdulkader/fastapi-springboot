package com.example.todoapp.Repository;

import com.example.todoapp.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepo extends JpaRepository<Users, UUID> {
    Users findByEmail(String email);
}
