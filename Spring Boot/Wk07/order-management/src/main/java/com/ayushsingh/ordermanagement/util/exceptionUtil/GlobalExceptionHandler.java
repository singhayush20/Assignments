package com.ayushsingh.ordermanagement.util.exceptionUtil;

import com.ayushsingh.ordermanagement.constants.AppConstants;
import com.ayushsingh.ordermanagement.util.responseUtil.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<String>> handleApiException(ApiException e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ApiResponse<>(AppConstants.ERROR_RESPONSE, e.getMessage(), AppConstants.ERROR_CODE), HttpStatus.OK);
    }
}
