package com.alinma.cib.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ClientFailureException extends RuntimeException {

    private static final long serialVersionUID = -859318070341717886L;

    @Getter
    private final String errorCode;

    public ClientFailureException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public ClientFailureException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ClientFailureException(Exception e) {
        super(e);
        this.errorCode = "0x823";
    }
}
