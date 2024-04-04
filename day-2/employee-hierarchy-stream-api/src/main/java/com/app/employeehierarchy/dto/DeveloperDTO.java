package com.app.employeehierarchy.dto;

public record DeveloperDTO(int employeeId, String name, double salary, String programmingLanguage) implements EmployeeDto {
}
