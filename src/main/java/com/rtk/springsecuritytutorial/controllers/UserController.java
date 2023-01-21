package com.rtk.springsecuritytutorial.controllers;

import com.rtk.springsecuritytutorial.model.dto.CreateUserRequestModel;
import com.rtk.springsecuritytutorial.model.dto.UserDTO;
import com.rtk.springsecuritytutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin()
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody CreateUserRequestModel request){
        return ResponseEntity.ok(userService.addUser(request));
    }
}
