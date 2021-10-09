package com.example.crud.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(UserNotFoundException e){
        HttpStatus notFound= HttpStatus.NOT_FOUND;
            ApiException apiException=new ApiException(e.getMessage(),notFound, ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(apiException,notFound);
    }

    @ExceptionHandler(value = {UserAlreadyInException.class})
    public ResponseEntity<Object> handleUserAlreadyInException(UserAlreadyInException e){
        HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(e.getMessage(),badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }
}
