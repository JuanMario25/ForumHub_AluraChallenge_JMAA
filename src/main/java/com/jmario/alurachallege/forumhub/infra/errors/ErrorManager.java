package com.jmario.alurachallege.forumhub.infra.errors;

import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErrorManager {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageError404(){
        return  ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manageError400(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(ValidationErrorData::new).toList();
        return  ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ValidationFailureException.class)
    public ResponseEntity manageValidationError(ValidationFailureException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity manageSQLIntegrityConstraintViolation(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    private record ValidationErrorData(String field, String error){
        public ValidationErrorData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
