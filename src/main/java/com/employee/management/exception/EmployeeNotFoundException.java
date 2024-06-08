package com.employee.management.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}