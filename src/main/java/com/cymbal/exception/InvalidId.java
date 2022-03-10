package com.cymbal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidId extends SQLException {
    public InvalidId(String reason){super(reason);}
}
