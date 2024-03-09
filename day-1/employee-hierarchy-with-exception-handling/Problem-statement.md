Problem Statement: Exception Handling in Employee Hierarchy

Extend the Employee Hierarchy program to incorporate exception handling for input validation. Implement checks to ensure that user inputs are valid, and handle potential exceptions gracefully.

1. **Exception Handling for Employee Attributes:**
   - Modify the constructors in the `Employee`, `Manager`, and `Developer` classes to include exception handling for input validation.
   - Ensure that the employee's name is not an empty string, the employee ID is a positive integer, and the salary is a non-negative double.
   - If any of the validations fail, throw an appropriate exception (e.g., `IllegalArgumentException`) with a meaningful error message.

2. **User Input in Testing:**
   - In the testing section, simulate user input by accepting values from the user for creating instances of `Manager` and `Developer`.
   - Implement a try-catch block to handle any exceptions thrown during the input process.
   - Prompt the user to re-enter the input if an exception occurs.

3. **Custom Exception Class:**
   - Create a custom exception class called `InvalidEmployeeDataException` that extends `Exception`.
   - Use this custom exception to handle scenarios where the employee data is invalid.

4. **Sample Input and Output:**

    ```
    Enter the manager's name:
    John Doe
    Enter the manager's ID:
    -123
    Invalid input: Employee ID cannot be negative
    Enter the manager's ID:
    123
    Enter the manager's salary:
    10000
    Enter the developer's name:
    Jane Smith
    Enter the developer's ID:
    456
    Enter the developer's salary:
    -5000
    Invalid input: Employee salary cannot be negative
    Enter the developer's salary:
    5000
    ```
    
    ```
    Manager Details:
    Name: John Doe
    ID: 123
    Salary: $10000.0
    Developer Details:
    Name: Jane Smith
    ID: 456
    Salary: $5000.0
    ```
   

