package com.davidezeodo.dev.web;

import com.davidezeodo.dev.dtos.request.CreateUserRequest;
import com.davidezeodo.dev.dtos.response.CreateUserResponse;
import com.davidezeodo.dev.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserServices userServices;

    @PostMapping("/api/account")
    public ResponseEntity<?> createUserAccount(@RequestBody CreateUserRequest createUserRequest){
        try {
            CreateUserResponse response = userServices.createUser(createUserRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception msgEx){
            return new ResponseEntity<>(msgEx.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
