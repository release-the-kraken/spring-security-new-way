package com.rtk.springsecuritytutorial.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestModel {
    private String login;
    private String password;

    private String email;
}
