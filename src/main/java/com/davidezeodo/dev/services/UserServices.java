package com.davidezeodo.dev.services;

import com.davidezeodo.dev.dtos.request.CreateUserRequest;
import com.davidezeodo.dev.dtos.response.CreateUserResponse;

public interface UserServices {
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
