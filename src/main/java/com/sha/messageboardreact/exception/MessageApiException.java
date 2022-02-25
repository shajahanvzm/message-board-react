package com.sha.messageboardreact.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MessageApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public MessageApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public MessageApiException(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }
}
