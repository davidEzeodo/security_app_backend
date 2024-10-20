package com.davidezeodo.dev.utilities;

import com.davidezeodo.dev.data.model.User;
import com.davidezeodo.dev.dtos.request.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public User map(CreateUserRequest createUserRequest){
        User newUser = new User();
        newUser.setFirstName(createUserRequest.getFirstName());
        newUser.setLastName(createUserRequest.getLastName());
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setPassword(createUserRequest.getPassword());
        newUser.setRole(createUserRequest.getRole());
        return newUser;
    }
}
