package com.example.authservice.exceptions;

public class InvalidCredentialException extends Exception{
    public InvalidCredentialException(String message) {
        super(message);
    }
}

