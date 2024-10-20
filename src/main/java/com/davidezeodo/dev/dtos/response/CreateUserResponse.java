package com.davidezeodo.dev.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse {
    private Long userId;
    private String message;
    private boolean status;
}
