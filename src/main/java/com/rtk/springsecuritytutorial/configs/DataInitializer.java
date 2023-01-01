package com.rtk.springsecuritytutorial.configs;

import com.rtk.springsecuritytutorial.model.UserEntity;
import com.rtk.springsecuritytutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @EventListener(ContextRefreshedEvent.class)
    public void initializeDatabase(){
        final String ADMIN_NAME = "His Highness The Admin";
        if(!userRepository.existsByUsername(ADMIN_NAME)){
            userRepository.save(
                    UserEntity.builder()
                            .username(ADMIN_NAME)
                            .password(passwordEncoder.encode("admin"))
                            .role(UserRoles.ADMIN.getAuthority())
                            .email("admin@email.com")
                            .accountNonExpired(true)
                            .accountNonLocked(true)
                            .credentialsNonExpired(true)
                            .build()
            );
        }
    }
}
