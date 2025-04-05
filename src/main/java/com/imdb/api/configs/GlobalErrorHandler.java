package com.imdb.api.configs;

import com.imdb.api.dtos.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Exception handler to provide a clean API error output
 */
@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDto> handleConstrainValidationException(ValidationException e, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Constrain Validation Error",
                StringUtils.truncate(e.getMessage(), 50),
                request.getRequestURI(),
                null);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDto> handleGeneralException(Throwable e, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error: %s, Cause: %s".formatted(e.getClass().getSimpleName(), e.getCause()),
                StringUtils.truncate(e.getMessage(), 50),
                request.getRequestURI(),
                null);
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
