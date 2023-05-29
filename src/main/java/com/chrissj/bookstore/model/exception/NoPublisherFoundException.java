package com.chrissj.bookstore.model.exception;

public class NoPublisherFoundException extends RuntimeException{
    public NoPublisherFoundException(int id){
        super(String.format("No publisher with id: %d was found", id));
    }
}
