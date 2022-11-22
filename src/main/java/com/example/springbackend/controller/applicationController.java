package com.example.springbackend.controller;

import com.example.springbackend.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class applicationController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResource(ResourceNotFoundException ex){
        return ex.getMessage();
    }
}
