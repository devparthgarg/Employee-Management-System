package com.employee.management.exception;

import lombok.Getter;

@Getter
public class InvalidRequestException extends Exception {

    public InvalidRequestException(String msg) {
        super(msg);
    }
}
