package com.iurify.casebackend.infrastructure.controller.dto;

public class ErrorDto {
    private String code;
    private String message;
    private String traceId;
    private boolean retryable;

    public ErrorDto(String code, String message, String traceId, boolean retryable) {
        this.code = code;
        this.message = message;
        this.traceId = traceId;
        this.retryable = retryable;
    }

    public String getCode() { return code; }
    public String getMessage() { return message; }
    public String getTraceId() { return traceId; }
    public boolean isRetryable() { return retryable; }
}
