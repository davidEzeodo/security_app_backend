package com.davidezeodo.dev;

import com.davidezeodo.dev.data.model.types.Role;
import com.davidezeodo.dev.dtos.request.CreateUserRequest;
import com.davidezeodo.dev.dtos.response.CreateUserResponse;
import com.davidezeodo.dev.services.UserServices;
import com.davidezeodo.dev.utilities.exceptions.UserAlreadyExists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;

    @Test
    void testThatUserCanCreateAccount(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Dave");
        createUserRequest.setLastName("Odo");
        createUserRequest.setEmail("davidodojunior@gmail.com");
        createUserRequest.setRole(Role.CUSTOMER);
        createUserRequest.setPassword("fruit123");

        CreateUserResponse response = userServices.createUser(createUserRequest);
        assertThat(response.getMessage(), is("Account Created Successfully."));
    }
    @Test
    void testThatExceptionIsThrownIfUserEntersEmailThatAlreadyExists(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Dave");
        createUserRequest.setLastName("Odo");
        createUserRequest.setEmail("davidodojunior@gmail.com");
        createUserRequest.setRole(Role.CUSTOMER);
        createUserRequest.setPassword("fruit123");

        assertThrows(UserAlreadyExists.class, () -> {
            userServices.createUser(createUserRequest);
        });
    }
}