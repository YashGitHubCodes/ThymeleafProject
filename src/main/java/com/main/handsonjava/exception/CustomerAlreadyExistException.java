package com.main.handsonjava.exception;

public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
