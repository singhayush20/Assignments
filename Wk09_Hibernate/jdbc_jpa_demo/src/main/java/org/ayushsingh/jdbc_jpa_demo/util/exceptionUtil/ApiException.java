package org.ayushsingh.jdbc_jpa_demo.util.exceptionUtil;

/**
 * Custom exception class for API-related exceptions.
 * Extends {@link RuntimeException}.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}
