package com.example.marshAssignment.service;

import com.example.marshAssignment.exception.EmployeeNotFoundException;
import com.example.marshAssignment.model.Employee;
import com.example.marshAssignment.model.EmployeeResponse;
import com.example.marshAssignment.feignClient.EmployeeClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeClient employeeClient;

    public Employee fetchEmployeeById(String employeeId) throws EmployeeNotFoundException, Exception {
        EmployeeResponse response = employeeClient.getEmployeeById(employeeId).getBody();

        if (response.getStatus().equalsIgnoreCase("success")) {
            Employee employee = response.getData();
            if (employee == null) {
                throw new EmployeeNotFoundException();
            }
            return employee;
        }
        throw new Exception("Employee service is not working.");
    }
}
