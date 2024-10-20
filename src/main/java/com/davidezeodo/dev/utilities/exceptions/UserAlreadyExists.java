package com.davidezeodo.dev.utilities.exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(String message){
        super(message);
    }
}
