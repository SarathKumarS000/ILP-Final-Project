package com.eminence.chitty.jwt.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class DuplicateRegistrationException {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleDuplicateRegistrationException(SQLIntegrityConstraintViolationException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
        errorDetails.setMessage(exception.getMessage());
        return new ResponseEntity<>("Duplicate entry", HttpStatus.CREATED);
    }
}
