package com.example.marshAssignment.controller;

import com.example.marshAssignment.exception.EmployeeNotFoundException;
import com.example.marshAssignment.model.Employee;
import com.example.marshAssignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
//@CrossOrigin()
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    // This is just for demo prospective otherwise constructor injection is preferred. // reflection.
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> employeeById(@PathVariable("employeeId") String employeeId,
                                                 @AuthenticationPrincipal Authentication authentication)
            throws EmployeeNotFoundException, Exception {

        LOGGER.info("Inside get employee Info  " + employeeId);

        Employee employee = null;
        try {
            employee = employeeService.fetchEmployeeById(employeeId);
        } catch (EmployeeNotFoundException e) {
            LOGGER.debug(e.getMessage());
            throw new EmployeeNotFoundException(); // Custom Exception
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


}
