package com.Jonet.YanVols.exceptions;

import org.springframework.http.HttpStatus;

public class YanVolsException extends RuntimeException{

    private String message;

    private HttpStatus status;

    public YanVolsException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
