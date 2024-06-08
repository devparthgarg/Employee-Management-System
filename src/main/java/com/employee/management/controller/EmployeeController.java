package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.exception.EmployeeNotFoundException;
import com.employee.management.exception.InvalidRequestException;
import com.employee.management.service.impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api")
@Tag(name = "Employee Controller API")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws InvalidRequestException {
        log.info("Got Create Request {}", employee);
        return new ResponseEntity<>(employeeServiceImpl.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeServiceImpl.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) throws EmployeeNotFoundException {
        return new ResponseEntity<>(employeeServiceImpl.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) throws EmployeeNotFoundException {
        employeeServiceImpl.updateEmployee(employee, id);
        return new ResponseEntity<>("Employee Record Updated for ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) throws EmployeeNotFoundException {
        employeeServiceImpl.deleteEmployee(id);
        return new ResponseEntity<>("Employee Record Deleted for ID: " + id, HttpStatus.OK);
    }

}
