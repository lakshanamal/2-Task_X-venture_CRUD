package com.example.crud.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,"User not found"),
    USER_ALREADY_EXIST(HttpStatus.BAD_REQUEST,"User already exist");
    private final HttpStatus httpStatus;
    private final String errorMsg;

    ErrorCode(HttpStatus errorCode, String errorMsg) {
        this.httpStatus=errorCode;
        this.errorMsg=errorMsg;
    }
}
