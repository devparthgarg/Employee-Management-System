package com.employee.management.handler;

import com.employee.management.controller.EmployeeController;
import com.employee.management.exception.UnauthorizedException;
import com.employee.management.exception.EmployeeNotFoundException;
import com.employee.management.exception.InvalidRequestException;
import com.employee.management.model.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(assignableTypes = EmployeeController.class)
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.UNAUTHORIZED)
    @org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedException.class)
    protected BaseResponse handleUnauthorizedException(final UnauthorizedException e) {
        return new BaseResponse(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED, e.getLocalizedMessage());
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidRequestException.class)
    private BaseResponse handleInvalidRequestException(final InvalidRequestException e) {
        return new BaseResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY, e.getLocalizedMessage());
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    private BaseResponse handleEmployeeNotFoundException(final EmployeeNotFoundException e) {
        return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }

}


