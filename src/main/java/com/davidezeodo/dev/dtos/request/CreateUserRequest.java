package com.davidezeodo.dev.dtos.request;

import com.davidezeodo.dev.data.model.types.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
