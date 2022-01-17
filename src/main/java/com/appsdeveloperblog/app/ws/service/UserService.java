package com.appsdeveloperblog.app.ws.service;

import com.appsdeveloperblog.app.ws.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetailsRequest);
}
