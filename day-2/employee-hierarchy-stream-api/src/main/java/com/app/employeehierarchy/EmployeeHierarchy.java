package com.app.employeehierarchy;


import com.app.employeehierarchy.model.Developer;
import com.app.employeehierarchy.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class EmployeeHierarchy {

    // TODO: Use Stream API to find the employee with the highest salary
    public static Employee findHighestPaidEmployee(List<Employee> employees) {

     //   return employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();

    var e = employees.stream().max((e1,e2)->(int)(e1.getSalary()-e2.getSalary()));
    return e.orElse(null);

    }


    // TODO: Use Stream API to count the number of developers in the collection
    public static long countDevelopers(List<Employee> employees) {

        return employees.stream().filter(e->e instanceof Developer).count();

    }

    // TODO: Use Stream API to calculate the average salary of all employees
    public static double calculateAverageSalary(List<Employee> employees) {

        // TODO: Use Stream API to calculate the average salary of all employees

 //        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);

          return employees.stream().map(Employee::getSalary).reduce(0.0, (a, b) -> a + b) / employees.size();

  //      return employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));

    }


    public static void main(String[] args) {
        // Create a collection to store employees
        List<Employee> employeeList = new ArrayList<>();

        // TODO: Add sample Manager and Developer instances to the collection

        // TODO: Print the initial list of employees

        // TODO: Use Stream API to filter employees based on salary range and display the results

        // TODO: Use Stream API to calculate the total salary of all employees

        // TODO: Allow user input to add new employees to the collection

        // TODO: Implement a user interface to interact with the program
    }
}
