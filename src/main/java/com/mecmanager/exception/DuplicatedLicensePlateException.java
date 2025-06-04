package com.mecmanager.exception;

public class DuplicatedLicensePlateException extends RuntimeException{

    public DuplicatedLicensePlateException(String licensePlate) {
        super("A car with license plate " + licensePlate + " already exists");
    }

}
