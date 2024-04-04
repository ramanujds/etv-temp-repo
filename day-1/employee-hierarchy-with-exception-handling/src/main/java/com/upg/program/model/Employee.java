package com.upg.program.model;

import com.upg.program.exception.InvalidEmployeeDataException;

public class Employee {

    private int employeeId;
    private String name;

    private double salary;

    public Employee(int employeeId, String name, double salary) throws InvalidEmployeeDataException {

        if (employeeId <= 0) {
            throw new InvalidEmployeeDataException("Employee ID cannot be less than or equal to 0");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException("Name cannot be null or empty");
        }
        if (salary <= 0) {
            throw new InvalidEmployeeDataException("Salary cannot be less than or equal to 0");
        }

        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
