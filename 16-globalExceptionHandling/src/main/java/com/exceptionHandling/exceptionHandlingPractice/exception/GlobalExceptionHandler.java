package com.exceptionHandling.exceptionHandlingPractice.exception;

import com.exceptionHandling.exceptionHandlingPractice.dto.ApiErrorResponseDTO;
import com.exceptionHandling.exceptionHandlingPractice.dto.ValidationErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handling DuplicateResourceException
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleDuplicateResourceException
    (DuplicateResourceException ex, HttpServletRequest request) {

        ApiErrorResponseDTO error = new ApiErrorResponseDTO(
                LocalDateTime.now(),
                false,
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }



    // Handling ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleResourceNotFoundException
    (ResourceNotFoundException ex, HttpServletRequest request) {

        ApiErrorResponseDTO error = new ApiErrorResponseDTO(
                LocalDateTime.now(),
                false,
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }



    // Handling MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleMethodArgumentNotValidException
    (MethodArgumentNotValidException ex, HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        map.put(error.getField(), error.getDefaultMessage()));

        ValidationErrorResponseDTO error = new ValidationErrorResponseDTO(
                LocalDateTime.now(),
                false,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Failed",
                request.getRequestURI(),
                map
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }



    // Handling Runtime Exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleRuntimeException
    (RuntimeException ex, HttpServletRequest request) {

        ApiErrorResponseDTO error = new ApiErrorResponseDTO(
                LocalDateTime.now(),
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "An unexpected server error occurred.",
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }



    // Handling Generic Exception (Safety net)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponseDTO> handleGenericException
    (Exception ex, HttpServletRequest request) {

        ApiErrorResponseDTO error = new ApiErrorResponseDTO(
                LocalDateTime.now(),
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Something went Wrong, Try again later!",
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}



