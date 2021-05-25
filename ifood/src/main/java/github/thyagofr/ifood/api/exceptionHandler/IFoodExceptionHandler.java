package github.thyagofr.ifood.api.exceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import github.thyagofr.ifood.domain.exceptions.BadRequestException;
import github.thyagofr.ifood.domain.exceptions.ConflictException;
import github.thyagofr.ifood.domain.exceptions.NotFoundException;

@RestControllerAdvice
public class IFoodExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception,
        WebRequest request
        ) {
            List<ErrorMessage.Field> fieldsWithError = new ArrayList<>();
            for (ObjectError error : exception.getBindingResult().getAllErrors()) {
                String fieldName = ((FieldError) error).getField();
                String fieldMessage = error.getDefaultMessage();
                fieldsWithError.add(new ErrorMessage.Field(fieldName,fieldMessage));
            }
            String message = String.format("%d campos possuem errors", fieldsWithError.size());
            return constructBody(HttpStatus.BAD_REQUEST, request, message, fieldsWithError);
        }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(
        NotFoundException exception,
        WebRequest request
        ) {
            return constructBody(HttpStatus.NOT_FOUND, request, exception.getMessage(), null);
            
        }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorMessage> handleConflictException(
        ConflictException exception,
        WebRequest request
        ) {
            return constructBody(HttpStatus.CONFLICT, request, exception.getMessage(), null);
            
        }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(
        BadRequestException exception,
        WebRequest request
        ) {
            return constructBody(HttpStatus.BAD_REQUEST, request, exception.getMessage(), null);
            
        }

    private ResponseEntity<ErrorMessage> constructBody(HttpStatus status, WebRequest request, String message, List<ErrorMessage.Field> fieldsWithError) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(message);
        errorMessage.setPath(getPath(request));
        errorMessage.setTimeStamp(OffsetDateTime.now());
        errorMessage.setFields(fieldsWithError);
        return new ResponseEntity<>(errorMessage, status);
    }

    private String getPath(WebRequest request) {
        return ((ServletWebRequest)request).getRequest().getRequestURI();
    }
    
}
