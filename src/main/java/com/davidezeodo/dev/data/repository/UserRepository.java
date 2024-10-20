package com.davidezeodo.dev.data.repository;

import com.davidezeodo.dev.data.model.User;
import com.davidezeodo.dev.dtos.request.CreateUserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByEmail(String email);
}
