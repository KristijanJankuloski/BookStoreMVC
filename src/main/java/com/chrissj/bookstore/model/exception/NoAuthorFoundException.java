package com.chrissj.bookstore.model.exception;

public class NoAuthorFoundException extends RuntimeException{
    public NoAuthorFoundException(int id){
        super(String.format("No Author found with id: %d", id));
    }
}
