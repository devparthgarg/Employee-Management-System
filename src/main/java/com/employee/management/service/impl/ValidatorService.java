package com.employee.management.service.impl;

import com.employee.management.exception.InvalidRequestException;
import com.employee.management.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ValidatorService {

    public void validateEmployeeDetails(Employee employee) throws InvalidRequestException {
        List<String> errors = new ArrayList<>();

        if (!isNameValid(employee.getFirstName())) {
            errors.add("First Name should contain alphabets only");
        }
        if (!isNameValid(employee.getLastName())) {
            errors.add("Last Name should contain alphabets only");
        }
        if (!isMobileValid(employee.getMobileNumber())) {
            errors.add("Mobile Number should contain numbers and must be of length 10");
        }
        if (!isEmailValid(employee.getEmail())) {
            errors.add("Email ID is invalid");
        }

        if (!errors.isEmpty()) {
            String validationErrors = Arrays.toString(errors.toArray());
            throw new InvalidRequestException("Validation Errors: " + validationErrors);
        }
    }

    private static boolean isNameValid(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private static boolean isMobileValid(String mobileNumber) {
        if (mobileNumber.length() == 10) {
            return mobileNumber.matches("\\d+");
        }
        return false;
    }

    private static boolean isEmailValid(String email) {
        if (email.contains(" ")) {
            return false;
        }
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        return atIndex > 0 && dotIndex > atIndex && dotIndex < email.length() - 1;
    }

}
