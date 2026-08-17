package com.caovinh.identity_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error" , HttpStatus.INTERNAL_SERVER_ERROR ),
    INVALID_KEY(8888, "Invalid message key", HttpStatus.BAD_REQUEST),

    USER_NOT_FOUND(1001, "User not found", HttpStatus.NOT_FOUND),
    INVALID_CREDENTIALS(1002, "Invalid credentials", HttpStatus.UNAUTHORIZED),
    USERNAME_ALREADY_EXISTS(1003, "Username already exists", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1004, "Username must be at least 4 characters long", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1005, "Password must be at least 4 characters long", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(1006, "You are not authorized to perform this action", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(1007, "Unauthenticated", HttpStatus.UNAUTHORIZED)
    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
