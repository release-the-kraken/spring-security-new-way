package com.rtk.springsecuritytutorial.service;

import com.rtk.springsecuritytutorial.configs.UserRoles;
import com.rtk.springsecuritytutorial.model.UserEntity;
import com.rtk.springsecuritytutorial.model.dto.CreateUserRequestModel;
import com.rtk.springsecuritytutorial.model.dto.UserDTO;
import com.rtk.springsecuritytutorial.model.mapper.UserMapper;
import com.rtk.springsecuritytutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.h2.mvstore.db.RowDataType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserDTO addUser(CreateUserRequestModel request) {
        UserEntity newUser = userMapper.mapCreateUserRequestToUserEntity(request);

        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(UserRoles.USER.getAuthority());

        return userMapper.mapUserEntityToUserDto(userRepository.save(newUser));
    }
}
