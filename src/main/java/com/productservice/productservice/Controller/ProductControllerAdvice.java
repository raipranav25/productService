package com.productservice.productservice.Controller;

import com.productservice.productservice.DTO.ExceptionDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException )
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMsg(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        return exceptionDto;
        //return new ResponseEntity<ExceptionDto>( exceptionDto, HttpStatus.NOT_FOUND);
        //System.out.println("Got product not found exception");
    }
}
