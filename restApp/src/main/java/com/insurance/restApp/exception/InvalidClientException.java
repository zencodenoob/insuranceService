package com.insurance.restApp.exception;

public class InvalidClientException extends RuntimeException{
    public InvalidClientException(String message) {
        super(message);
    }
}
