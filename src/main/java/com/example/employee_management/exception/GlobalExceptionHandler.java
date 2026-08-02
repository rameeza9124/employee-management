package com.example.employee_management.exception;

import com.example.employee_management.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(EmployeeNotFoundException.class)

    public ResponseEntity<ErrorResponseDto> handleEmployeeNotFoundException(
            EmployeeNotFoundException ex) {

        logger.warn("{}", ex.getMessage());

        ErrorResponseDto errorResponse = new ErrorResponseDto(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(errorResponse);


    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleDepartmentNotFoundException(
            DepartmentNotFoundException ex) {
            logger.warn("{}", ex.getMessage());

        ErrorResponseDto errorResponse = new ErrorResponseDto(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

}
