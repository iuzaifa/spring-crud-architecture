package com.bitsnbyte_product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
    * @ResponseStatus(value =  HttpStatus.NOT_FOUND)
    * This annotation tells Spring to return HTTP 404 Not Found
    * when this exception is thrown. It indicates that the requested
    * resource does not exist (e.g., ID not found in the database).
*/
@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String message){
        super(message);
    }
}
