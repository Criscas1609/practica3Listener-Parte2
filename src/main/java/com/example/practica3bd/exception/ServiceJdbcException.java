package com.example.practica3bd.exception;

public class ServiceJdbcException extends RuntimeException{
    public ServiceJdbcException(String message) {
        super(message);
    }
    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}

