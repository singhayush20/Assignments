package com.ayushsingh.ta_candidate.util.exceptionUtil;


import com.ayushsingh.ta_candidate.constants.AppConstants;
import com.ayushsingh.ta_candidate.util.responseUtil.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<String>> handleApiException(ApiException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ERROR_CODE,AppConstants.ERROR_RESPONSE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiResponse<String>> handleExpiredJwtException(ExpiredJwtException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ACCESS_TOKEN_EXPIRED,AppConstants.ERROR_RESPONSE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ApiResponse<String>> handleMalformedJwtException(MalformedJwtException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ERROR_CODE,AppConstants.ERROR_RESPONSE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ApiResponse<String>> handleSignatureException(SignatureException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ERROR_CODE,AppConstants.ERROR_RESPONSE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<ApiResponse<String>> handleUnsupportedJwtException(UnsupportedJwtException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ERROR_CODE,AppConstants.ERROR_RESPONSE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(IllegalArgumentException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ERROR_CODE,AppConstants.ERROR_RESPONSE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(InsufficientRolesException.class)
    public ResponseEntity<ApiResponse<String>> handleInsufficientRolesException(InsufficientRolesException e){
        ApiResponse<String> apiResponse=new ApiResponse<>(AppConstants.ACCESS_DENIED_CODE,AppConstants.ACCESS_DENIED_MESSAGE,e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
