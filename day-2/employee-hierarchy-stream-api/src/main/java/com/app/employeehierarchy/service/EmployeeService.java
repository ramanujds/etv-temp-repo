package com.app.employeehierarchy.service;

import com.app.employeehierarchy.dto.DeveloperDTO;
import com.app.employeehierarchy.dto.EmployeeDto;
import com.app.employeehierarchy.model.Developer;
import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.util.EmployeeDtoUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    List<Employee> employees = new ArrayList<>();



    public EmployeeDto addEmployee(EmployeeDto employee){
        employees.add(EmployeeDtoUtil.dtoToEntity(employee));
        return employee;
    }

    public EmployeeDto getEmployeeById(int id){
       return   employees.stream().filter(e->e.getEmployeeId()==id)
                 .map(EmployeeDtoUtil::entityToDto)
                 .findFirst().get();

    }



}
