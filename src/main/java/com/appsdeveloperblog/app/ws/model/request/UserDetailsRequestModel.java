package com.appsdeveloperblog.app.ws.model.request;

import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Valid
public class UserDetailsRequestModel {

    @NotNull(message = "first name cannot be null")
    private String firstName;
    @NotNull(message = "first name cannot be null")
    private String lastName;
    @NotNull(message = "first name cannot be null")
    @Email
    private String email;
    @NotNull(message = "first name cannot be null")
    @Size(min = 8,max = 16,message = "password must be equal or greater than 8 and equal or less than 16 characters")
    private String password;
}
