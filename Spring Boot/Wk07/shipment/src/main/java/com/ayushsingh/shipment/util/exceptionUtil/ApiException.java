package com.ayushsingh.shipment.util.exceptionUtil;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
