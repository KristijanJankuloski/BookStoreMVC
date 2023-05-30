package com.chrissj.bookstore.model.exception;

public class NoProductFoundException extends RuntimeException{
    public NoProductFoundException(int id){
        super(String.format("No product with id: %d", id));
    }
}
