package com.blueberry.websocket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 12/12/2016.
 */
@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
public class SpitterException extends RuntimeException {
    public SpitterException() {
    }

    public SpitterException(String msg) {
        super(msg);
    }
}
