package com.bitsnbyte_product.exception;


import com.bitsnbyte_product.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice // This makes the class a global exception handler
public class GlobalExceptionHandler {

    /**
     * @ExceptionHandler(SomeException.class)
     * Exception handler for SomeException.
     * Provides a custom response to replace the default error page,
     * enabling cleaner error management and improved user experience.
    */

    @ExceptionHandler(CategoriesExitsException.class)
    public ResponseEntity<ExceptionResponseDTO> categoriesExitsGlobalExceptionHandler(CategoriesExitsException exception, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
    }


    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> categoryNotFoundGlobalHandler(CategoryNotFoundException exception, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }

    public ResponseEntity<ExceptionResponseDTO> globalExceptionHandler(Exception exception, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
    }
}
