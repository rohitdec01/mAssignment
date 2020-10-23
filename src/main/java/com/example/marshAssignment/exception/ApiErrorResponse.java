package com.example.marshAssignment.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class ApiErrorResponse {
    private String message;
    private List<String> details;
}
