package com.example.todoapp.Service.impl;

import com.example.todoapp.Model.Users;
import com.example.todoapp.Repository.UsersRepo;
import com.example.todoapp.Service.UserServices;
import com.example.todoapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserServices {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepo repo;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity<UserDTO> register(UserDTO dto){
        Users users = UserDTO.toEntity(dto);
        users.setPassword(passwordEncoder.encode(dto.getPassword()));

        Users saved = repo.save(users);

        return ResponseEntity.ok(UserDTO.from(saved));
    }
    @Override
    public ResponseEntity<UserDTO> login(UserDTO dto){
        Users users = UserDTO.toEntity(dto);
        Users findUser = repo.findByEmail(users.getEmail());

        return ResponseEntity.ok(UserDTO.from(findUser));
    }
}
