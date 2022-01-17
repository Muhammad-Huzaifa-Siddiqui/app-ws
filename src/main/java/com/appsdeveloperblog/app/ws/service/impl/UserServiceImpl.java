package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.model.response.UserRest;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String,UserRest> users;
    Utils utils;

    public UserServiceImpl(){}

    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequest) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetailsRequest.getEmail());
        returnValue.setFirstName(userDetailsRequest.getFirstName());
        returnValue.setLastName(userDetailsRequest.getLastName());
        String userId = utils.generateUserId();
        returnValue.setUserId(userId);
        if(users==null)
            users = new HashMap<>();

        users.put(userId,returnValue);
        return returnValue;
    }
}
