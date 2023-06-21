package com.backend.springboot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    private final String fieldName;
    private final int fieldValue;

    public ResourceNotFoundException(String fieldName,int fieldValue){
        super(String.format("Employee not found with name: %s and value: %s",fieldName,fieldValue));
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
