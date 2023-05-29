package com.chrissj.bookstore.model.exception;

public class NoCategoryFoundException extends RuntimeException{
    public NoCategoryFoundException(int id) {
        super(String.format("No category with id:%d was found", id));
    }
}
