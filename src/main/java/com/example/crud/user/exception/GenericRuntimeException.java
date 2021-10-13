package com.example.crud.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class GenericRuntimeException extends RuntimeException{
    private final HttpStatus httpStatus;
    public GenericRuntimeException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.httpStatus=errorCode.getHttpStatus();
    }
}
