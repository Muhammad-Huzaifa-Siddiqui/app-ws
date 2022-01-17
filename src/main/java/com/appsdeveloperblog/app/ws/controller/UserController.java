package com.appsdeveloperblog.app.ws.controller;

import com.appsdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appsdeveloperblog.app.ws.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.model.response.UserRest;
import com.appsdeveloperblog.app.ws.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")  //htt://localhost:XxXx/users
public class UserController {

    Map<String,UserRest> users;
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public String getUsers(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort",defaultValue = "desc", required = false)String sort){
        return "get user was called page: "+page + " and limit: "+limit+ " and sort: "+sort;
    }

    @GetMapping(path = "/{userId}",
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getUser(@PathVariable String userId){
        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces= {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequest){
        UserRest returnValue = userService.createUser(userDetailsRequest);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE} ,
            produces= {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public UserRest updateUser(@PathVariable String userId,@RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequest){
        UserRest userDetails = users.get(userId);
        userDetails.setFirstName(updateUserDetailsRequest.getFirstName());
        userDetails.setLastName(updateUserDetailsRequest.getLastName());
        users.put(userId,userDetails);
        return userDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        users.remove(id);
        return ResponseEntity.noContent().build();
    }

}
