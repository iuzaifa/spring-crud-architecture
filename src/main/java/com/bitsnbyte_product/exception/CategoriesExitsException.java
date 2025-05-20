package com.bitsnbyte_product.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
    * @ResponseStatus(value = HttpStatus.CONFLICT)
    * This annotation tells Spring to respond with HTTP 409 Conflict status
    * when this exception is thrown, indicating a resource conflict (e.g., duplicate entry).
*/
@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoriesExitsException extends RuntimeException {

    public CategoriesExitsException(String message){
        super(message);
    }
}
