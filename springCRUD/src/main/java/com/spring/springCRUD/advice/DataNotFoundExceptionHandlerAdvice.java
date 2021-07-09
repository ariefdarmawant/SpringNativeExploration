package com.spring.springCRUD.advice;

import com.spring.springCRUD.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DataNotFoundExceptionHandlerAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity handleException(DataNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
