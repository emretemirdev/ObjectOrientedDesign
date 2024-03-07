package com.emretemir.finalproject.RestAPI.exception;

public class CarsNotFoundException extends RuntimeException{
    public CarsNotFoundException(String msg) {
            super(msg);
        }

}
