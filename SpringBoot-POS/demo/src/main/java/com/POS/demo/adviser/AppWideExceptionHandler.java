package com.POS.demo.adviser;

import com.POS.demo.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StandardResponse> handleClassNotFoundException(ClassNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(404,e.getMessage(),e),
                HttpStatus.NOT_FOUND
        );
    }
}
