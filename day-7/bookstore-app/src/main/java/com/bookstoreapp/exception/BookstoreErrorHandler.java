package com.bookstoreapp.exception;

import com.bookstoreapp.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;


public class BookstoreErrorHandler {


    /* TODO:
    create a method to handle BookNotFoundException
    Return a ResponseEntity of ErrorResponse
    Return a status of 404
     */
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex) {
        // TODO: Implement this method
        return null;

    }

    // create a method to handle BookAlreadyExistsException

    /* TODO:
    create a method to handle BookAlreadyExistsException
    Return a ResponseEntity of ErrorResponse
    Return a status of 409
     */
    public ResponseEntity<ErrorResponse> handleBookAlreadyExistsException(BookAlreadyExistsException ex) {
        // TODO: Implement this method
        return null;

    }

    /* TODO:
    create a method to handle ValidationException
    Return a ResponseEntity of ErrorResponse
    Return a status of 400
     */

    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex) {
        return null;

    }


    /* TODO:
    create a method to handle Exception
    Return a ResponseEntity of ErrorResponse
    Return a status of 500
     */

    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return null;

    }



}
