package com.company.TestErd.Dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler
    public ResponseEntity<ResponseDto<Void>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                ResponseDto.<Void>builder()
                        .message("validation error")
                        .code(-3)
                        .errorlist(
                                e.getBindingResult().getFieldErrors().stream()
                                .map(fieldError -> {
                                    String message = fieldError.getDefaultMessage();
                                    String rejection = String.valueOf(fieldError.getRejectedValue());
                                    String field = fieldError.getField();
                                    return new ErrorDto(
                                            field, String.format
                                            (" message :: %s  rejection :: %s", message, rejection));
                                }).toList())
                        .build()
        );
    }
}
