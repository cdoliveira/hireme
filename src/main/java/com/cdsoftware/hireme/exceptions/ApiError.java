package com.cdsoftware.hireme.exceptions;

import java.time.LocalDateTime;


public class ApiError extends Exception {

    private String errorMsg;
    private LocalDateTime timestamp;
    private String errorCode;

    public ApiError(String message, String errorMsg, LocalDateTime timestamp, String errorCode) {

        super(message);
        this.errorMsg = errorMsg;
        this.timestamp = timestamp;
        this.errorCode = errorCode;
    }
}
