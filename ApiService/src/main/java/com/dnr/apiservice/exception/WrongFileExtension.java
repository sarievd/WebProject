package com.dnr.apiservice.exception;

public class WrongFileExtension extends RuntimeException {
    public WrongFileExtension (String errorMessage){
        super(errorMessage);
    }
}
