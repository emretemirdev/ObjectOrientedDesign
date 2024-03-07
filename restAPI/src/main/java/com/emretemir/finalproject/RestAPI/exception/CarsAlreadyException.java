package com.emretemir.finalproject.RestAPI.exception;

public class CarsAlreadyException extends RuntimeException {
    public CarsAlreadyException(String msg) {
        super(msg);
    }
}
