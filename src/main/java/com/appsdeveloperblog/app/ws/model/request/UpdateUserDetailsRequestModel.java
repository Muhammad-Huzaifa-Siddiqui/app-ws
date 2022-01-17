package com.appsdeveloperblog.app.ws.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserDetailsRequestModel {
    @NotNull(message = "first name cannot be null")
    private String firstName;
    @NotNull(message = "first name cannot be null")
    private String lastName;
}
