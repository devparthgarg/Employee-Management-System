package com.employee.management.exception;

import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String msg) {
        super(msg);
    }
}
