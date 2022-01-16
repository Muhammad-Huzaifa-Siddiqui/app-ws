package com.appsdeveloperblog.app.ws.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")  //htt://localhost:xxxx/users
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId){
        return "get user was called with user id = "+userId;
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }

}
