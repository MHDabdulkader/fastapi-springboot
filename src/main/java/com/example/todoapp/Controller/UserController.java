package com.example.todoapp.Controller;

import com.example.todoapp.Service.UserServices;
import com.example.todoapp.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;


@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO dto){
        return userServices.register(dto);
    }

    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO dto){
        return userServices.login(dto);
    }

    @PostMapping("logout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }

        return ResponseEntity.ok("Logout successful");
    }

}
