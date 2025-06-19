package com.example.todoapp.Controller;

import com.example.todoapp.Service.UserServices;
import com.example.todoapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO dto){
        return userServices.register(dto);
    }
    @GetMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO dto){

    }

}
