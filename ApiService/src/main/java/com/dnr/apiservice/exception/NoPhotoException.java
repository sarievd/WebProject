package com.dnr.apiservice.exception;

public class NoPhotoException extends RuntimeException {
    public NoPhotoException(String errorMessage){
        super(errorMessage);
    }
}
