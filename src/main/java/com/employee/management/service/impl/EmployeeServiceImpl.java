package com.employee.management.service.impl;

import com.employee.management.exception.EmployeeNotFoundException;
import com.employee.management.exception.InvalidRequestException;
import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ValidatorService validatorService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ValidatorService validatorService) {
        this.employeeRepository = employeeRepository;
        this.validatorService = validatorService;
    }

    private static final String EMPLOYEE_NOT_FOUND = "Employee ID not present in database";

    @Override
    public Employee saveEmployee(Employee employee) throws InvalidRequestException {
        validatorService.validateEmployeeDetails(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }

        throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND);
    }

    @Override
    public void updateEmployee(Employee newEmployee, long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setMobileNumber(newEmployee.getMobileNumber());
            employee.setEmail(newEmployee.getEmail());
            employeeRepository.save(employee);
            return;
        }

        throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND);
    }

    @Override
    public void deleteEmployee(long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            return;
        }

        throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND);
    }
}
