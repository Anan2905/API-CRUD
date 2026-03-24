package com.devteria.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED( 1001,  "User existed");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }


}
