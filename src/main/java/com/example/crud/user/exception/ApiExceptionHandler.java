package com.example.crud.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleApiRequestException(UserNotFoundException e){
        HttpStatus notFound= HttpStatus.NOT_FOUND;
            ApiException apiException=new ApiException(e.getMessage(),notFound, ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(apiException,notFound);
    }

    @ExceptionHandler(value = {UserAlreadyInException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleUserAlreadyInException(UserAlreadyInException e){
        HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(e.getMessage(),badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }
    // Generic exception handle
    @ExceptionHandler(value = {GenericRuntimeException.class})
    public ResponseEntity<Object> genericExceptionHandler(GenericRuntimeException e){
        ApiException apiException=new ApiException(e.getMessage(),e.getHttpStatus(), ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,e.getHttpStatus());
    }
}
