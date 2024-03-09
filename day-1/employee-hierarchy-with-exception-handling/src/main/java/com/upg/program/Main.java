package com.upg.program;

import com.upg.program.exception.InvalidEmployeeDataException;
import com.upg.program.model.Developer;
import com.upg.program.model.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accepting user input for Manager
            System.out.println("Enter Manager details:");
            System.out.print("Name: ");
            String managerName = scanner.nextLine();
            System.out.print("Employee ID: ");
            int managerID = Integer.parseInt(scanner.nextLine());
            System.out.print("Salary: ");
            double managerSalary = Double.parseDouble(scanner.nextLine());
            System.out.print("Team Size: ");
            int managerTeamSize = Integer.parseInt(scanner.nextLine());

            Manager manager = new Manager(managerName, managerID, managerSalary, managerTeamSize);
            manager.displayDetails();
        } catch (NumberFormatException | InvalidEmployeeDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Accepting user input for Developer
            System.out.println("\nEnter Developer details:");
            System.out.print("Name: ");
            String developerName = scanner.nextLine();
            System.out.print("Employee ID: ");
            int developerID = Integer.parseInt(scanner.nextLine());
            System.out.print("Salary: ");
            double developerSalary = Double.parseDouble(scanner.nextLine());
            System.out.print("Programming Language: ");
            String programmingLanguage = scanner.nextLine();

            Developer developer = new Developer(developerName, developerID, developerSalary, programmingLanguage);
            developer.displayDetails();
        } catch (NumberFormatException | InvalidEmployeeDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    }
}