package com.rtk.springsecuritytutorial.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequestModel {
    private String login;
    private String password;
}
