package com.rtk.springsecuritytutorial.repository;

import com.rtk.springsecuritytutorial.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public Optional<UserEntity> findByUsername(String username);

    public boolean existsByUsername(String username);

}
