package com.example.crud.user.exception;

public class UserAlreadyInException extends RuntimeException{
    public UserAlreadyInException(String message) {
        super(message);
    }

    public UserAlreadyInException(String message, Throwable cause) {
        super(message, cause);
    }
}
