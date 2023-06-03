package com.chrissj.bookstore.model.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userId){
        super(String.format("User with [%s] userId was not found", userId));
    }
}
