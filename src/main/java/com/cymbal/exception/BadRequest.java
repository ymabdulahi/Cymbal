package com.cymbal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest extends IllegalArgumentException {
    public BadRequest(String message){super(message);}
}
