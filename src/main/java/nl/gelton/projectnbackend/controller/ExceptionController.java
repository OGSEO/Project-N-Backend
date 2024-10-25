package nl.gelton.projectnbackend.controller;

import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.exception.InvalidCredentialsException;
import nl.gelton.projectnbackend.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleAllExceptions(Exception ex, WebRequest request) {
        Response errorResponse = Response.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .statusMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Response> handleRecordNotFoundException(Exception ex, WebRequest request) {
        Response errorResponse = Response.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Response> handleInvalidCredentialsException(Exception ex, WebRequest request) {
        Response errorResponse = Response.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .statusMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> exception(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError ->
                        fieldError.getField() + " " +
                                fieldError.getDefaultMessage())
                .collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }

//
//    @ExceptionHandler(value = IOException.class)
//    public ResponseEntity<String> exeption(IOException exception){
//        String message = "Problemen met file opslag";
//        return ResponseEntity.internalServerError().body(message);
//
//    }
}
