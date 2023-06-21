package com.backend.springboot.controller;

import com.backend.springboot.entity.Employee;
import com.backend.springboot.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int employeeId){
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int employeeId,
                                                    @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,employeeId),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
    }
}
