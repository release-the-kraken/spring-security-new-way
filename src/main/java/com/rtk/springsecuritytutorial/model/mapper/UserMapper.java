package com.rtk.springsecuritytutorial.model.mapper;

import com.rtk.springsecuritytutorial.model.UserEntity;
import com.rtk.springsecuritytutorial.model.dto.CreateUserRequestModel;
import com.rtk.springsecuritytutorial.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapUserEntityToUserDto(UserEntity user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public UserEntity mapCreateUserRequestToUserEntity(CreateUserRequestModel request){
        return UserEntity.builder()
                .username(request.getLogin())
                .password(request.getPassword())
                .email(request.getEmail())
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
    }

}
