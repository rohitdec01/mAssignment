package com.example.marshAssignment.feignClient;

import com.example.marshAssignment.model.EmployeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "employee-service",
        url = "http://dummy.restapiexample.com/api/v1/"
)
public interface EmployeeClient {

    @GetMapping("employee/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("employeeId") String employeeId);
}
