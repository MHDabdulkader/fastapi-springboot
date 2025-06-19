package com.example.todoapp.dto;

import com.example.todoapp.Model.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;
@Builder
@Data
public class UserDTO {
    private UUID id;
    private String email;
    private String password;
    private String name;

    public static Users toEntity(UserDTO dto){
        return Users
                .builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .build();
    }

    public static UserDTO from(Users users){
        return UserDTO.builder()
                .email(users.getEmail())
                .name(users.getName())
                .build();
    }
}
