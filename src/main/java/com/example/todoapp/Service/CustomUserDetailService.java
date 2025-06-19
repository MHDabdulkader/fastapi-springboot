package com.example.todoapp.Service;

import com.example.todoapp.Model.UserPrincipal;
import com.example.todoapp.Model.Users;
import com.example.todoapp.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UsersRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = repo.findByEmail(email);
        if(users == null){
            System.out.println("User not founded : "+ email);
            throw new UsernameNotFoundException("User not founded : "+email);
        }

        return new UserPrincipal(users);
    }
}
