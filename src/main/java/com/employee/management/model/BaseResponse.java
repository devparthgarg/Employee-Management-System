package com.employee.management.model;

import org.springframework.http.HttpStatus;

public record BaseResponse(int httpStatusCode, HttpStatus httpStatus, String message) {
}
