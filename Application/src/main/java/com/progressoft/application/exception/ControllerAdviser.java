package com.progressoft.application.exception;

import com.progressoft.exception.AccountNotFoundException;
import com.progressoft.exception.InvalidTransactionException;
import com.progressoft.exception.NotEnoughBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map> handleAccountNotFoundException(
            AccountNotFoundException ex, WebRequest request) {

        Map<String , Object> exception = new HashMap<>();
        exception.put("message" , ex.getMessage());
        exception.put("status_code" , HttpStatus.NOT_FOUND.value());
        exception.put("url" , ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<Map> handleInvalidTransactionException(
            InvalidTransactionException ex, WebRequest request) {

        Map<String , Object> exception = new HashMap<>();
        exception.put("message" , ex.getMessage());
        exception.put("status_code" , HttpStatus.BAD_REQUEST.value());
        exception.put("url" , ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotEnoughBalanceException.class)
    public ResponseEntity<Map> handleNotEnoughBalanceException(
            NotEnoughBalanceException ex, WebRequest request) {

        Map<String , Object> exception = new HashMap<>();
        exception.put("message" , ex.getMessage());
        exception.put("status_code" , HttpStatus.BAD_REQUEST.value());
        exception.put("url" , ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
