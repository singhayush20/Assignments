package org.ayushsingh.jdbc_jpa_demo.util.responseUtil;

import lombok.Getter;
import lombok.Setter;
import org.ayushsingh.jdbc_jpa_demo.constants.AppConstants;


/**
 * Response wrapper class for API responses.
 * Provides a standardized structure for responses containing data, message, and code.
 *
 * @param <T> The type of data to be included in the response.
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@Getter
@Setter
public class ApiResponse<T> {

    /** The data included in the response. */
    T data;

    /** The message describing the response. */
    String message;

    /** The code representing the response status. */
    String code;

    public ApiResponse(T data, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public ApiResponse(T data) {
        this.data = data;
        this.message= AppConstants.SUCCESS_MESSAGE;
        this.code=AppConstants.SUCCESS_CODE;
    }
}
