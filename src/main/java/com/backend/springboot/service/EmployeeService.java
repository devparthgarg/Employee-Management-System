package com.backend.springboot.service;

import com.backend.springboot.entity.Employee;
import com.backend.springboot.exception.ResourceNotFoundException;
import com.backend.springboot.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeService implements EmployeeServiceInterface {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee=employeeRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        try{
            employeeRepository.findById(id);
            employeeRepository.deleteById(id);
        }catch(ResourceNotFoundException resourceNotFoundException){
            log.info("Resource Not Found Exception");
            throw resourceNotFoundException;
        }
    }
}
