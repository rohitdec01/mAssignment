package com.example.marshAssignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String employee_name;
    private Long employee_salary;
    private Integer employee_age;
    private String profile_image;
}
