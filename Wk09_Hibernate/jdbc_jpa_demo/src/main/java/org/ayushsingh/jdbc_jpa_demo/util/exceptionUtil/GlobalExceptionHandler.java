package org.ayushsingh.jdbc_jpa_demo.util.exceptionUtil;

import org.ayushsingh.jdbc_jpa_demo.constants.AppConstants;
import org.ayushsingh.jdbc_jpa_demo.util.responseUtil.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for thrown exceptions.
 * Provides methods to handle specific exceptions and return appropriate responses.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Handles {@link ApiException} and returns an appropriate ApiResponse with error details.
     *
     * @param e The ApiException instance.
     * @return ResponseEntity containing ApiResponse with error details.
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<String>> handleApiException(ApiException e) {
        return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), AppConstants.ERROR_MESSAGE,AppConstants.ERROR_CODE), HttpStatus.OK);
    }


    /**
     * Handles {@link ConstraintViolationException} and returns an appropriate ApiResponse with error details.
     *
     * @param e The ConstraintViolationException instance.
     * @return ResponseEntity containing ApiResponse with error details.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), AppConstants.ERROR_MESSAGE,AppConstants.ERROR_CODE), HttpStatus.OK);
    }
}
