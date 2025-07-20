package com.example.productservice.Exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(){
        super("Resource not found");
    }

}
