package com.andree.synctalk.exceptions;

import com.andree.synctalk.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response<Void>> handleBadRequestException(BadRequestException e, WebRequest request) {
        return new ResponseEntity<>(
                Response.<Void>builder().
                        success(false).
                        message(e.getMessage()).
                        description(request.getDescription(false)).
                        build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response<Void>> handleNotFoundException(NotFoundException e, WebRequest request) {
        return new ResponseEntity<>(
                Response.<Void>builder().
                        success(false).
                        message(e.getMessage()).
                        description(request.getDescription(false)).
                        build(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Response<Void>> handleUnauthorizedException(UnauthorizedException e, WebRequest request) {
        return new ResponseEntity<>(
                Response.<Void>builder().
                        success(false).
                        message(e.getMessage()).
                        description(request.getDescription(false)).
                        build(), HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(
                Response.<Map<String, String>>builder().
                        success(false).
                        description(request.getDescription(false)).
                        data(errors).
                        build(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


}
