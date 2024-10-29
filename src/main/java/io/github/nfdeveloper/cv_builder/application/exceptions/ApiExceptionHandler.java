package io.github.nfdeveloper.cv_builder.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.nfdeveloper.cv_builder.exceptions.CpfUniqueViolationException;
import io.github.nfdeveloper.cv_builder.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException(EntityNotFoundException ex,
			HttpServletRequest request, BindingResult result){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
            }

    @ExceptionHandler(CpfUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> cpfUniqueViolationException(CpfUniqueViolationException ex,
        HttpServletRequest request, BindingResult result){
            return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
        }
}
