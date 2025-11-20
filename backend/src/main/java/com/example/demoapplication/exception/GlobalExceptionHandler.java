package com.example.demoapplication.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(ResourceNotFoundException ex)
    {
        Map<String,Object> error = new HashMap<>();
        error.put("TimeStamp" , LocalDateTime.now());
        error.put("Status", HttpStatus.NOT_FOUND.value());
        error.put("Error ","Not Found");
        error.put("Message",ex);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Map<String,Object>> handleException(Exception ex)
    {
        Map<String,Object> error = new HashMap<>();
        error.put("TimeStamp" ,LocalDateTime.now());
        error.put("Status",HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("Error","Internal Server Error");
        error.put("Message",ex);
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
