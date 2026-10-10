package com.exceptionHandling.exceptionHandlingPractice.dto;

import java.time.LocalDateTime;

public class ApiErrorResponseDTO {
    private LocalDateTime timeStamp;
    private boolean success;
    private int status;
    private String error;
    private String message;
    private String path;

    public ApiErrorResponseDTO(LocalDateTime timeStamp,
                               boolean success,
                               int status,
                               String error,
                               String message,
                               String path) {
        this.timeStamp = timeStamp;
        this.success = success;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
