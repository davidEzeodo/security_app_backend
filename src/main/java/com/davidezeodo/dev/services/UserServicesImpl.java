package com.davidezeodo.dev.services;

import com.davidezeodo.dev.data.model.User;
import com.davidezeodo.dev.data.repository.UserRepository;
import com.davidezeodo.dev.dtos.request.CreateUserRequest;
import com.davidezeodo.dev.dtos.response.CreateUserResponse;
import com.davidezeodo.dev.utilities.Mapper;
import com.davidezeodo.dev.utilities.exceptions.UserAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        String email = validateUserAccountByEmail(createUserRequest.getEmail());
        createUserRequest.setEmail(email);
        User user = mapper.map(createUserRequest);
        CreateUserResponse response = new CreateUserResponse();
        User savedUser = userRepository.save(user);
        response.setUserId(savedUser.getId());
        response.setMessage("Account Created Successfully.");
        response.setStatus(true);
        return response;
    }
    private String validateUserAccountByEmail(String email){
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findUserByEmail(email));
        if(optionalUser.isPresent()){
            throw new UserAlreadyExists("User already exists.");
        }
        return email;
    }
}
