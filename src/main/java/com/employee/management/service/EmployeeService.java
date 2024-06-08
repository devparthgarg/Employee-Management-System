package com.employee.management.service;

import com.employee.management.exception.EmployeeNotFoundException;
import com.employee.management.exception.InvalidRequestException;
import com.employee.management.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee) throws InvalidRequestException;

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id) throws EmployeeNotFoundException;

    void updateEmployee(Employee employee, long id) throws EmployeeNotFoundException;

    void deleteEmployee(long id) throws EmployeeNotFoundException;
}
