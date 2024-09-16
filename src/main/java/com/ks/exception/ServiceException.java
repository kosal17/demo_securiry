package com.ks.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class ServiceException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private String detailMessage;

    public ServiceException() {
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(Integer code,String message) {
        this.message = message;
        this.code = code;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }

}
