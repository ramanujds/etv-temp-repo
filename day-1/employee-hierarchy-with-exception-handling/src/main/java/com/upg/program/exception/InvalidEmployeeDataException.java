package com.upg.program.exception;

public class InvalidEmployeeDataException extends RuntimeException {

    public InvalidEmployeeDataException(String message){
        super(message);
    }

}
