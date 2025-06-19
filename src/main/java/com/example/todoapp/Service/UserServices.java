package com.example.todoapp.Service;

import com.example.todoapp.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserServices {
    ResponseEntity<UserDTO> register(UserDTO dto);
    ResponseEntity<UserDTO> login(UserDTO dto);
}
