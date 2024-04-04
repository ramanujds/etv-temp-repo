package com.upg.program.model;

import com.upg.program.exception.InvalidEmployeeDataException;

public class Manager extends Employee{

    private int teamSize;

    public Manager(String name, int employeeId, double salary, int teamSize) {
        super(employeeId, name, salary);
        if (teamSize <= 0) {
            throw new InvalidEmployeeDataException("Team size cannot be less than or equal to 0");
        }
        this.teamSize = teamSize;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }

}
