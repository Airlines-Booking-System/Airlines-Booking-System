package com.app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(Throwable.class)
    public Object handleNotFoundException(Throwable ex) {
        return ex.getCause();
    }

    // Add more exception handler methods for other custom exceptions
}