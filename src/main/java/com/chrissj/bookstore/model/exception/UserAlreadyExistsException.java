package com.chrissj.bookstore.model.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String username){
        super(String.format("User with username: %s was not found", username));
    }
}
