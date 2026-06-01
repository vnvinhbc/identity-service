package com.caovinh.identity_service.exception;

import org.springframework.jdbc.datasource.init.UncategorizedScriptException;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(8888, "Invalid message key"),

    USER_NOT_FOUND(1001, "User not found"),
    INVALID_CREDENTIALS(1002, "Invalid credentials"),
    USERNAME_ALREADY_EXISTS(1003, "Username already exists"),
    USERNAME_INVALID(1004, "Username must be at least 4 characters long"),
    PASSWORD_INVALID(1005, "Password must be at least 4 characters long"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
