package com.productservice.productservice.Exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg)
    {
        super(msg);
    }
}
