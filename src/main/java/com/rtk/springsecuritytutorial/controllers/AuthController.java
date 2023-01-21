package com.rtk.springsecuritytutorial.controllers;

import com.rtk.springsecuritytutorial.model.dto.AuthenticationRequestModel;
import com.rtk.springsecuritytutorial.model.dto.AuthenticationResponseModel;
import com.rtk.springsecuritytutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseModel> authenticate(@RequestBody AuthenticationRequestModel request){

        return ResponseEntity.ok(userService.authenticate(request));
    }


}
