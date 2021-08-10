package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull(message = "email cannot be null.")
    @Size(min=2, message = "email not be less than characters")
    @Email
    private String email;

    @NotNull(message = "name cannot be null.")
    @Size(min=8, message = "equal or grater than 8 characters \n" +
            "and less than 16 Characters")
    private String name;

    @NotNull(message = "pwd cannot be null.")
    @Size(min=2, message = "name not be less than two characters")
    private String pwd;


}
