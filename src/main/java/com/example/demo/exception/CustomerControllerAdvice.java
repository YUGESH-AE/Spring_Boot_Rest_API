package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(value = NoSuchCustomer.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(NoSuchCustomer ex){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_GATEWAY.value());
        errorMessage.setMessage(ex.getMsg());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage>handleValidationException(MethodArgumentNotValidException ex){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getBindingResult().getAllErrors()
                .stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));

        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ErrorMessage> handleConstraintViolationEception(ConstraintViolationException ex){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getConstraintViolations()
                .stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
