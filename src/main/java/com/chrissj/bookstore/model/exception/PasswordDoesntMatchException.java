package com.chrissj.bookstore.model.exception;

public class PasswordDoesntMatchException extends RuntimeException{
    public PasswordDoesntMatchException(){
        super("Password doesnt match");
    }
}
