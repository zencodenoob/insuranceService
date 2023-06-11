package com.insurance.restApp.exception;

import com.insurance.restApp.api.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var response = new ExceptionResponse();
        var message = e.getFieldErrors()
                .stream()
                .map(f -> f.getField()+"[value :"+f.getRejectedValue()+"] : "+f.getDefaultMessage())
                .collect(Collectors.joining(","));
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError("Incorrect Arguments");
        response.setMessage(message);
        response.setTimestamp(Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }
    @ExceptionHandler({InvalidClientException.class})
    ResponseEntity<ExceptionResponse> handleInvalidClientException(InvalidClientException e){
        var response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),"BAD REQUEST",e.getMessage(),Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler({InvalidPolicyException.class})
    ResponseEntity<ExceptionResponse> handleInvalidPolicyException(InvalidPolicyException e){
        var response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),"BAD REQUEST",e.getMessage(),Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler({InvalidClaimsException.class})
    ResponseEntity<ExceptionResponse> handleInvalidClaimsException(InvalidClaimsException e){
        var response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),"BAD REQUEST",e.getMessage(),Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler({Exception.class})
    ResponseEntity<ExceptionResponse> handleRequestBodyExceptions(Exception e){
        var response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),"BAD REQUEST","INVALID INPUT PARAMETERS",Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
