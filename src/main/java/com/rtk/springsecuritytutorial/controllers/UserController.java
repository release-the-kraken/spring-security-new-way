package com.rtk.springsecuritytutorial.controllers;

import com.rtk.springsecuritytutorial.model.dto.CreateUserRequestModel;
import com.rtk.springsecuritytutorial.model.dto.UserDTO;
import com.rtk.springsecuritytutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin()
public class UserController {

    private final UserService userService;

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postNewUser(@RequestBody CreateUserRequestModel request){
        return userService.addUser(request);
    }
}
