package com.dnr.apiservice.exception;

public class ImageSizeException extends RuntimeException {
    public ImageSizeException(String errorMessage){
        super(errorMessage);
    }
}
