package com.app.employeehierarchy.util;

import com.app.employeehierarchy.dto.DeveloperDTO;
import com.app.employeehierarchy.dto.EmployeeDto;
import com.app.employeehierarchy.model.Developer;
import com.app.employeehierarchy.model.Employee;

public class EmployeeDtoUtil {

    public static EmployeeDto entityToDto(Employee employee){

        return switch (employee) {
            case Developer developer ->
                    new DeveloperDTO(developer.getEmployeeId(), developer.getName(), developer.getSalary(), developer.getProgrammingLanguage());

            default -> null;
        };
    }

    public static Employee dtoToEntity(EmployeeDto employeeDto){

        return switch (employeeDto){
            case DeveloperDTO d -> new Developer(d.employeeId(),d.name(),d.salary(),d.programmingLanguage());
            default -> null;
        };

    }

}
