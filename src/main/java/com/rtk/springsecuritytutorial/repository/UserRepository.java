package com.rtk.springsecuritytutorial.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    private final static List<UserDetails> APP_USERS = Arrays.asList(
            new User("admin@email.com",
                    "admin",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("user@email.com",
                    "user",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))

    );
    public UserDetails findUserByEmail(String email){
        return APP_USERS.stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(email)));
    }
}
