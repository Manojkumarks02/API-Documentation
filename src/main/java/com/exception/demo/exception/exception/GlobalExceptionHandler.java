package com.exception.demo.exception.exception;

import com.exception.demo.exception.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleNoSuchElementException(NoSuchElementException noSuchElementException){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(noSuchElementException.getMessage());
        return apiResponse;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(productNotFoundException.getMessage());
        return apiResponse;
    }
}
