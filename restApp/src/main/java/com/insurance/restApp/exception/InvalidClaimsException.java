package com.insurance.restApp.exception;

public class InvalidClaimsException extends RuntimeException{

    public InvalidClaimsException(String message) {
        super(message);
    }
}
