package com.insurance.restApp.exception;

public class InvalidPolicyException extends RuntimeException{

    public InvalidPolicyException(String message) {
        super(message);
    }
}
