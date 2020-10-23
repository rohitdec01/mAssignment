package com.example.marshAssignment.model;

import lombok.Data;
import org.h2.util.json.JSONString;

@Data
public class EmployeeResponse {
    private String status;
    private Employee data;
    private String message;
}
