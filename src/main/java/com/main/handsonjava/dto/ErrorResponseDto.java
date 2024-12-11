package com.main.handsonjava.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto {

    private String apiPath;
    private HttpStatus errorCode;
    private String message;

    public ErrorResponseDto(String apiPath, HttpStatus errorCode, String message, LocalDateTime timestamp) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    private LocalDateTime timestamp;

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
