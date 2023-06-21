package com.scaffolding.scaffolding.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String msg) {
        super("Error: "+msg);
    }
    
}
