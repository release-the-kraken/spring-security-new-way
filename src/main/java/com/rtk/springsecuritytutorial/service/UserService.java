package com.rtk.springsecuritytutorial.service;

import com.rtk.springsecuritytutorial.configs.JwtService;
import com.rtk.springsecuritytutorial.configs.UserRoles;
import com.rtk.springsecuritytutorial.model.UserEntity;
import com.rtk.springsecuritytutorial.model.dto.AuthenticationRequestModel;
import com.rtk.springsecuritytutorial.model.dto.AuthenticationResponseModel;
import com.rtk.springsecuritytutorial.model.dto.CreateUserRequestModel;
import com.rtk.springsecuritytutorial.model.dto.UserDTO;
import com.rtk.springsecuritytutorial.model.mapper.UserMapper;
import com.rtk.springsecuritytutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtService jwtService;


    public UserDTO addUser(CreateUserRequestModel request) {
        UserEntity newUser = userMapper.mapCreateUserRequestToUserEntity(request);

        newUser.setUsername(request.getLogin());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(UserRoles.USER);

        UserEntity savedUser = userRepository.save(newUser);

        UserDTO userDto = userMapper.mapUserEntityToUserDto(savedUser);
        userDto.setToken(jwtService.generateToken(savedUser));

        return userDto;
    }

    public AuthenticationResponseModel authenticate(AuthenticationRequestModel request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );

        final UserEntity user = userRepository.findByUsername(request.getLogin())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username."));

        return AuthenticationResponseModel.builder()
                .token(jwtService.generateToken(user))
                .build();

    }
}
