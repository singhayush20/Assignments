package com.ayushsingh.ta_candidate.util.exceptionUtil;

public class RefreshTokenExpiredException extends RuntimeException {

    public RefreshTokenExpiredException(String s) {
        super(s);
    }
}
