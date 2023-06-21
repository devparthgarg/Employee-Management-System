package com.backend.springboot.service;

import com.backend.springboot.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployee(int id);
}
