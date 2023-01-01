package com.rtk.springsecuritytutorial.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private Long id;

    private String username;
    private String password;

    private String email;
}
