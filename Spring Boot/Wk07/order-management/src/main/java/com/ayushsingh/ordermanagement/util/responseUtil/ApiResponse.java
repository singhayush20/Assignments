package com.ayushsingh.ordermanagement.util.responseUtil;

import com.ayushsingh.ordermanagement.constants.AppConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private String message;
    private T data;
    private Integer code;

    public ApiResponse(T data) {
        this.data = data;
        this.message= AppConstants.SUCCESS_MESSAGE;
        this.code=AppConstants.SUCCESS_CODE;
    }

    public ApiResponse(String message, T data, Integer code) {
        this.message = message;
        this.data = data;
        this.code = code;
    }
}
