package com.employee.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health Controller API")
public class HealthController {

    @GetMapping(value = "/health")
    public HttpStatus health() {
        return HttpStatus.OK;
    }

}
