package com.devteria.identity_service.controller;

import com.devteria.identity_service.Service.UserService;
import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request){
        return userService.creatUser(request);
    }
}
